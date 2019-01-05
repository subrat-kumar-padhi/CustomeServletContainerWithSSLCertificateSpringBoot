package com.neel.cscs;

import java.io.File;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

@Component
public class CustomeServletContainer implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

	// Any beans of this type will get a callback with the server factory before the
	// server itself is started,
	// so you can set the port, address, error pages etc.

	@Value("${key-store}")
	private String keystoreFile;
	@Value("${key-alias}")
	private String keystoreAlias;
	@Value("${key-store-type}")
	private String keystoreType;
	@Value("${key-password}")
	private String keystorePass;
	@Value("${port}")
	private int tlsPort;

	@Override
	public void customize(TomcatServletWebServerFactory factory) {
		factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {

			@Override
			public void customize(Connector connector) {
				connector.setPort(5555);
				connector.setSecure(true); //to make it too HTTP/HTTPS
				connector.setScheme("https");
				connector.setAttribute("keyAlias", "tomcat");
				connector.setAttribute("keystorePass", "password");

				File file = new File(keystoreFile);
				String absoluteKeystoreFile = file.getAbsolutePath();

				connector.setAttribute("keystoreFile", absoluteKeystoreFile);
				connector.setAttribute("clientAuth", "false");
				connector.setAttribute("sslProtocol", "TLS");
				connector.setAttribute("SSLEnabled", true);

				Http11NioProtocol protocal = (Http11NioProtocol) connector.getProtocolHandler();
				protocal.setSSLEnabled(true);
				protocal.setKeystoreFile(keystoreFile);
				protocal.setKeystorePass(keystorePass);
				protocal.setKeystoreType(keystoreType);
				protocal.setKeyAlias(keystoreAlias);

			}

		});

	}

}

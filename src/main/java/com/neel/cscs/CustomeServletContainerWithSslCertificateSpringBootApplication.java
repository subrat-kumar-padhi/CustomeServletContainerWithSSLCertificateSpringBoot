package com.neel.cscs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomeServletContainerWithSslCertificateSpringBootApplication {

	//First create jks file in classpath
	//command to generate jks file
	//keytool -genkey -v -keystore my-release-key.jks -alias alias_name -keyalg RSA -keysize 2048 -validity 10000
	
	//For Testing
	//To test in local, enable chrome setting
	//past in crome :  chrome://flags/#allow-insecure-localhost 
	//test with this url - https://localhost:5555/test 


	public static void main(String[] args) {
		SpringApplication.run(CustomeServletContainerWithSslCertificateSpringBootApplication.class, args);
	}

}


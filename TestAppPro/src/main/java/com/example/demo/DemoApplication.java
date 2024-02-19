package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) {
		String containerId = System.getenv("CONTAINER_ID");
		System.setProperty("name", containerId);
		String topicName = System.getenv("TOPIC_NAME");
		System.setProperty("topic_name", topicName);
		SpringApplication.run(DemoApplication.class, args);
	}

}

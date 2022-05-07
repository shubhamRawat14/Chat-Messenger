package com.knoldus.chatmessenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Locale;

@SpringBootApplication
@EnableEurekaClient
public class ChatmessengerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ChatmessengerApplication.class, args);
	}

}

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan({ "com.example.Controller","com.example.Service","com.example.ServiceImpl" })
@EnableElasticsearchRepositories(basePackages= "com.example.Repository")
@SpringBootApplication(scanBasePackages= {"com.example.Controller","com.example.Service","com.example.ServiceImpl"})
@EnableSwagger2
public class NewsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsAppApplication.class, args);
		System.out.println("oki");
	}

}

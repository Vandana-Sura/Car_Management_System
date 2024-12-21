package com.example.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import springfox.documentation.service.ApiInfo;

@SpringBootApplication
//@EnableSwagger2
//@EnableOpenApi
public class SpringBootCarManagementAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCarManagementAppApplication.class, args);
	}
	
//	@Bean
//	public Docket getCustomizedDocket() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("com.example.demo"))
//				.paths(PathSelectors.any())
//				.build();
//}
//	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}

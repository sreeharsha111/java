package com.spring.project.carparking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.support.RequestHandledEvent;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@SpringBootApplication
@EnableSwagger2
public class CarparkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarparkingApplication.class, args);
	}
		@Bean
		public Docket Swaggerconfiguration() {
			return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.paths(PathSelectors.ant("/api/*"))
					.build()
					.apiInfo(apiInfo());
					
	
	}
		 private ApiInfo apiInfo() {
		        return new ApiInfoBuilder()
		                .title("Parking Management API")
		                .description("Manage the parking slots by dynamically adding and managing the slots using the APIs")
		                .version("1.0")
		                .build();
		 }
}

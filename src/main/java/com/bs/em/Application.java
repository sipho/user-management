package com.bs.em;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
	public Docket manageUsersApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("Manage users")
				.apiInfo(manageUsersApiInfo())
				.select()
				.paths(regex("/api.*"))
				.build();
	}

	private ApiInfo manageUsersApiInfo() {
		return new ApiInfoBuilder()
				.title("Manage User API's")
				//.description("Manage user API's")
				//.termsOfServiceUrl("Terms and conditions url")
				.contact("Black Swan")
				.license("Apache License Version 2.0")
				//.licenseUrl("
				// Black Swan licence url")
				.version("2.0")
				.build();
	}
}

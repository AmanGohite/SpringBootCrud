package com.crudexample.crudExampleApplication.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.builders.ApiInfoBuilder;

import springfox.documentation.service.Contact;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
   @Bean
   public Docket apiDocket() {
       
       Docket docket =  new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.crudexample.crudExampleApplication.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
       
       return docket;
       
    } 
   
   private ApiInfo metaData() {
       return new ApiInfoBuilder()
               .title("REST API")
               .description("\"Spring Boot CRUD REST API \"")
               .version("1.0.0")
               .license("Apache License Version 2.0")
               .licenseUrl("//https://github.com/AmanGohite")
               .contact(new Contact("Aman Gohite", "//https://github.com/AmanGohite", "AmanGohite"))
               
               .build();
   }
  
   
   protected void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry.addResourceHandler("swagger-ui.html")
               .addResourceLocations("classpath:/META-INF/resources/");

       registry.addResourceHandler("/webjars/**")
               .addResourceLocations("classpath:/META-INF/resources/webjars/");
   }
}
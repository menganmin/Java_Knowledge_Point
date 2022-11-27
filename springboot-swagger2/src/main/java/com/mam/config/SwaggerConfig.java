package com.mam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author Anmin
 * @Date 2022/11/27
 * Swagger UI 配置信息
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket controllerApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api文档")
                .apiInfo(new ApiInfoBuilder()
                        .title("swagger 在线文档案例")
                        .description("用于测试API")
                        .version("V1.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mam.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}

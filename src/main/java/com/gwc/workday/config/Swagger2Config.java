package com.gwc.workday.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

  @Bean
  public Docket createRestApi() {
    ParameterBuilder tokenPar = new ParameterBuilder();
    List<Parameter> pars = new ArrayList<>();
    tokenPar.name("X-Request-Token").description("令牌token")
        .modelRef(new ModelRef("string"))
        .parameterType("header")
        .required(true).build();
    pars.add(tokenPar.build());

    return new Docket(DocumentationType.SWAGGER_2)
        .groupName("工作日API")
        .genericModelSubstitutes(DeferredResult.class)
        .useDefaultResponseMessages(true)
        .forCodeGeneration(true)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.gwc.workday"))
        .build()
        // .globalOperationParameters(pars)
        .apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("工作日RESTful APIs")
        .description(initContextInfo())
        .termsOfServiceUrl("https://github.com/peer44/workday")
        .contact(
            new Contact("程高伟", "https://github.com/peer44/workday", "peer44@qq.com"))
        .version("1.0")
        .build();
  }

  private String initContextInfo() {
    StringBuffer sb = new StringBuffer();
    sb.append("以下是工作日的API文档");
    return sb.toString();
  }
}

package za.ac.nwu.das.web.sb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.util.Collections;

@Configuration
@EnableSwagger2
@Import(springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig{

    @Value("${swagger.application.version}")
    private String appVersion;
    @Value("${swagger.application.name}")
    private String appName;
    @Value("${swagger.application.description}")
    private String appDescr;

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .apiInfo(apiInfo());
    }

    //localhost:8080/account-system/mvc

    private ApiInfo apiInfo() {
        return new ApiInfo(
            appName,
            appDescr,
            appVersion,
            "",
            new Contact("Monique", "", "moniquenagel24.mn@gmail.com"),
            "",
            "",
            Collections.emptyList()
        );
    }


}

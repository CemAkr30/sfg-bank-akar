package ca.springframework.sfgbankakar.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAutoConfiguration
@EnableWebMvc
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    /**Swagger dediğimiz framework bizlere Postman'i gereksiz hale getiren bir framework.
     API'mizin kendi içerisine bir arayüz kurarak GET, POST,
    DELETE, UPDATE gibi işlemleri yapmanızı sağlayan, API'nin metotlarını
    kod içerisinde dokümante edebildiğiniz bir framework.**/

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/");
    }
}

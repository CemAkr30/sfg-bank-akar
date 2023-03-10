package ca.springframework.sfgbankakar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@ComponentScan(basePackages = "ca.springframework.sfgbankakar.*")
//@EnableR2dbcRepositories
public class SfgBankAkarApplication {

    public static void main(String[] args) {
        SpringApplication.run(SfgBankAkarApplication.class, args);
    }

}

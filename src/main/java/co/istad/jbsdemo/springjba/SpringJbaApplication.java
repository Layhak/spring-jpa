package co.istad.jbsdemo.springjba;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @io.swagger.v3.oas.annotations.info.Info(title = "Data Analytic Restful API",description = "This is a best api course i have learn so far",contact = @Contact(name = "Jame Smith",email = "james@gmail.com",url = "localhost/super_smos")))
public class SpringJbaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJbaApplication.class, args);
    }

}

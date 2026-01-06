package agrial.stage.film.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI myOpenAPI() {
        // Informations de contact
        Contact contact = new Contact();
        contact.setEmail("c.lelong@agrial.com");
        contact.setName("Colynne LELONG - Stage Agrial");

        // Informations générales de l'API
        Info info = new Info()
                .title("API Cinéma Agrial")
                .version("1.0.0")
                .contact(contact)
                .description("Cette API permet de gérer le catalogue des films, les directeurs et les genres cinématographiques.");

        return new OpenAPI().info(info);
    }
}
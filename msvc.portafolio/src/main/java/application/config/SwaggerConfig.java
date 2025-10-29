package application.config;

import java.util.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig{

	@Bean
	   public OpenAPI defineOpenApi() {
	       Server server = new Server();
	
	       server.setUrl("http://localhost:8002");
	       server.setDescription("Development");

	       Contact myContact = new Contact();
	       myContact.setName("Soporte Técnico");
	       myContact.setEmail("soporte@nibirutechsolutions.com");

	       Info information = new Info()
	               .title("Portafolio Management System API")
	               .version("1.0")
	               .description("This API exposes endpoints to manage portafolio (category, sub-category, tax, product).")
	               .contact(myContact);
	       return new OpenAPI().info(information).servers(List.of(server));
	   }
	
}

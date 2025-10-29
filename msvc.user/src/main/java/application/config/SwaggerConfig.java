package application.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {
	@Bean
	   public OpenAPI defineOpenApi() {
	       Server server = new Server();
	
	       server.setUrl("http://localhost:8001");
	       server.setDescription("Development");

	       Contact myContact = new Contact();
	       myContact.setName("Soporte Técnico");
	       myContact.setEmail("soporte@nibirutechsolutions.com");

	       Info information = new Info()
	               .title("User Management System API")
	               .version("1.0")
	               .description("This API exposes endpoints to manage user (tenant, user, company, permissions).")
	               .contact(myContact);
	       return new OpenAPI().info(information).servers(List.of(server));
	   }
}

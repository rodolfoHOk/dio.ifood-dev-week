package me.dio.ifood.sacola.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;

@Configuration
public class SpringDocConfig {

	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Sacola ifood Dev Week - DIO")
						.version("v1")
						.description("REST API Sacola ifood Dev Week da DIO")
				
				).tags(Arrays.asList(
						new Tag().name("Clientes").description("Gerencia os clientes"),
						new Tag().name("Restaurantes").description("Gerencia os restaurantes"),
						new Tag().name("Produtos").description("Gerencia os produtos"),
						new Tag().name("Sacolas").description("Gerencia as sacolas"),
						new Tag().name("Items").description("Gerencia os items")
					)
				)
		;
	}
}

package com.registro.usuarios.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;

@Configuration
public class SwaggerConfig {
    
    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
            .info(new Info()
                .title("API de Registro de Usuarios")
                .description("API REST para el manejo de usuarios y autenticación")
                .version("1.0.0")
                .contact(new Contact()
                    .name("Tu Nombre")
                    .email("tu.email@ejemplo.com")));
    }
}
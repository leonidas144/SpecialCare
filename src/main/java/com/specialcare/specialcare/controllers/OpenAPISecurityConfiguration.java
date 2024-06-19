package com.specialcare.specialcare.controllers;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@Configuration
@OpenAPIDefinition(servers = @Server(url = "http://localhost:8080", description = "Production"))
public class OpenAPISecurityConfiguration {
    
}

package com.midominio.biblioteca1.app.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	
	// Si sobreescribimos este método estamos mapeando la ruta real del
	//   disco duro con la ruta que se utiliza en los templates y así 
	//   no es necesario cambiar nada

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/upload/**")
		.addResourceLocations("file:/opt/upload/");
	}

	// ** se corresponde con un nombre variable de la imagen
}

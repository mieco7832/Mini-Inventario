package com.miec.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.miec.repository.*;

@Configuration
public class Beans {
	// Instacias de los repositorios
	@Bean
	public ProductoRepository productoRepository() {
		return new ProductoRepository();
	}
	
	@Bean
	public CaracteristicaRepository caracteristicaRepository() {
		return new CaracteristicaRepository();
	}
	
}

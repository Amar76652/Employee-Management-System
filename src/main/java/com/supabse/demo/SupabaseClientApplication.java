package com.supabse.demo;

import com.supabse.demo.config.SupabaseConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(SupabaseConfig.class)
public class SupabaseClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupabaseClientApplication.class, args);
	}

}

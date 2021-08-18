package com.getarrays;

import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class EmployeemanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeemanagerApplication.class, args);
	}
	
	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowCredentials(true);
		corsConfig.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfig.setAllowedHeaders(Arrays.asList(	"Origin",
													"Access-Control-Allow-Origin",
													"Content-Type",
													"Accept",
													"Authorization",
													"Origin, Accept",
													"X=Requested-With",
													"Access-Control-Request-Method",
													"Access-Control-Request-Headers"
									));
		corsConfig.setExposedHeaders(Arrays.asList( "Origin",
													"Content-Type",
													"Accept",
													"Authorization",
													"Access-Control-Allow-Origin",
													"Access-Control-Allow-Credentials"										
									));
		corsConfig.setAllowedMethods(Arrays.asList("GET",
													"POST",
													"PUT",
													"DELETE",
													"OPTIONS"
									));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigSource = new UrlBasedCorsConfigurationSource();
		/*this below was shown in getArrays video tutorial
		 * urlBasedCorsConfigSource.registerCorsConfiguration(path:"/**", corsConfig);
		 */
		urlBasedCorsConfigSource.registerCorsConfiguration("/**", corsConfig);
		return new CorsFilter(urlBasedCorsConfigSource);
	}

}

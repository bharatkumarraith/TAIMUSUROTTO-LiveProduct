package com.example.spotifyapplication;

import com.example.spotifyapplication.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class SpotifyapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpotifyapplicationApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean filterBean()
	{
		FilterRegistrationBean filterRegistration=new FilterRegistrationBean();
		filterRegistration.setFilter(new JwtFilter());
		filterRegistration.addUrlPatterns("/spotify-app/get-User-Details","/spotify-app/add-song-to-playlist");
		return filterRegistration;

	}
	@Bean
	public FilterRegistrationBean filterRegistrationBean()
	{
		final CorsConfiguration configuration= new CorsConfiguration();
		configuration.setAllowCredentials(true);
		configuration.addAllowedOrigin("http://localhost:4200");
		configuration.addAllowedHeader("*");
		configuration.addAllowedMethod("*");
		final UrlBasedCorsConfigurationSource source= new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**",configuration);
		FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean(new CorsFilter(source));
		filterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return filterRegistrationBean;
	}
}

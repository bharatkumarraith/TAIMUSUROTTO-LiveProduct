package com.stackroute.authenticationService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.security.Principal;

@SpringBootApplication
@RestController
public class AuthenticationServiceApplication {

	@GetMapping
	public String welcome()
	{
		return "welcome to google";
	}


	@GetMapping("/user")
	public Principal user(Principal principal)
	{
		System.out.println("username"+principal.getClass().getSimpleName());
		return principal;
	}


	public static void main(String[] args) {
		SpringApplication.run(AuthenticationServiceApplication.class, args);
	}


	  @Bean
 public FilterRegistrationBean filterRegistrationBean(){
    final CorsConfiguration config = new CorsConfiguration();
    config.setAllowCredentials(true);
    config.addAllowedOrigin("http://localhost:4200");
    config.addAllowedHeader("*");
    config.addAllowedMethod("*");

    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**",config);

    FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
    bean.setOrder(Ordered.HIGHEST_PRECEDENCE);

    return bean;
 }

}

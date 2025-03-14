package myfiles.GC.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**") // Allow CORS for all endpoints under /api
                        .allowedOriginPatterns("https://fgc-wnzg.onrender.com") // Allowed origin patterns
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Allowed methods
                        .allowedHeaders("*") // Allowed headers
                        .allowCredentials(true); // Allow credentials (e.g., cookies)
            }
        };
    }
}

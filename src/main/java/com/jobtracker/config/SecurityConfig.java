package com.jobtracker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jobtracker.security.JwtFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .cors(cors -> cors.configurationSource(corsConfigurationSource())) // 🔥 IMPORTANT FIX
            .sessionManagement(session ->
                session.sessionCreationPolicy(
                    org.springframework.security.config.http.SessionCreationPolicy.STATELESS
                )
            )
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/**").permitAll()
                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
public org.springframework.web.cors.CorsConfigurationSource corsConfigurationSource() {

    org.springframework.web.cors.CorsConfiguration configuration =
            new org.springframework.web.cors.CorsConfiguration();

    configuration.setAllowedOrigins(java.util.List.of(
        "https://job-tracker-frontend-orpin.vercel.app"
    ));

    configuration.setAllowedMethods(java.util.List.of("GET","POST","PUT","DELETE","OPTIONS"));
    configuration.setAllowedHeaders(java.util.List.of("*"));
    configuration.setAllowCredentials(true);

    org.springframework.web.cors.UrlBasedCorsConfigurationSource source =
            new org.springframework.web.cors.UrlBasedCorsConfigurationSource();

    source.registerCorsConfiguration("/**", configuration);

    return source;
}
}
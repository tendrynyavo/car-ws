package com.example.carws.security;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationEntryPoint;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter; 
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.boot.autoconfigure.security.SecurityProperties;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    SecurityProperties restSecProps;

    @Autowired
    public SecurityFilter tokenAuthenticationFilter;

    @Bean
    public AuthenticationEntryPoint restAuthenticationEntryPoint() {
        return (httpServletRequest, httpServletResponse, e) -> {
            Map<String, Object> errorObject = new HashMap<>();
            int errorCode = 401;
            errorObject.put("message", e.getMessage());
            errorObject.put("error", HttpStatus.UNAUTHORIZED);
            errorObject.put("code", errorCode);
            errorObject.put("timestamp", new Timestamp(new Date().getTime()));
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            httpServletResponse.setStatus(errorCode);
            httpServletResponse.getWriter().write(objectMapper.writeValueAsString(errorObject));
        };
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(restSecProps.getAllowedOrigins());
        configuration.setAllowedMethods(restSecProps.getAllowedMethods());
        configuration.setAllowedHeaders(restSecProps.getAllowedHeaders());
        configuration.setAllowCredentials(restSecProps.isAllowCredentials());
        configuration.setExposedHeaders(restSecProps.getExposedHeaders());
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors().configurationSource(this.corsConfigurationSource()).and()
            .csrf().disable().formLogin().disable()
            .httpBasic().disable().exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint())
            .and().authorizeHttpRequests(request -> {
                request
                    .requestMatchers("/api/users/inscription_valide/**").permitAll()
                    .requestMatchers("/api/users/inscription").permitAll()
                    .requestMatchers("/api/users/login").permitAll()
                    .requestMatchers("/api/users/authentification").permitAll()
                    .requestMatchers("/api/users/token/**").permitAll()
                    .anyRequest().authenticated();
            })
            .addFilterBefore(tokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    //             .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                // .antMatchers(restSecProps.getAllowedPublicApis().toArray(String[]::new)).permitAll()
    //             .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
    //             .antMatchers(HttpMethod.OPTIONS, "api/**").permitAll()
    //             .anyRequest().authenticated().and()
    //             .addFilterBefore(tokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
    //             .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
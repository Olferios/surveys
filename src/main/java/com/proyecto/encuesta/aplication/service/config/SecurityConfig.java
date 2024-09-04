package com.proyecto.encuesta.aplication.service.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.proyecto.encuesta.aplication.service.user.UserDetailServiceImpl;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
            .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF para simplificar
            .authorizeHttpRequests(auth -> {

                auth.requestMatchers("/css/**", "/js/**", "/images/**").permitAll();
                auth.requestMatchers(HttpMethod.GET, "/api/**").hasAnyRole("ADMIN","USER");
                // Endpoints públicos
                auth.requestMatchers(HttpMethod.GET, "/", "/login").permitAll();
                auth.requestMatchers(HttpMethod.GET,  "/index").hasAnyRole("ADMIN");
                auth.requestMatchers(HttpMethod.GET,  "/home").hasAnyRole("ADMIN","USER");
                auth.requestMatchers(HttpMethod.GET,  "/users").hasAnyRole("ADMIN","USER");
                auth.requestMatchers(HttpMethod.GET,  "/gestion").hasRole("ADMIN");
                // Endpoints privados
       
                auth.requestMatchers(HttpMethod.POST, "/auth/post").hasAnyRole("ADMIN", "DEVELOPER");
                // Cualquier otra solicitud requiere autenticación
                auth.anyRequest().hasAnyRole("ADMIN");
            })
            .formLogin(form -> form
                .loginPage("/login") // Página personalizada de inicio de sesión
                .defaultSuccessUrl("/home", true) // Redirigir al usuario a /home después de iniciar sesión
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout") // Redirige a la página de inicio de sesión después de cerrar sesión
                .permitAll()
            )
            .build();
    }

    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)
    // throws Exception {
    // return httpSecurity
    // .csrf(csrf -> csrf.disable())
    // .httpBasic(Customizer.withDefaults())
    // .sessionManagement(session ->
    // session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
    // .build();
    // }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailServiceImpl userDetailService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailService);
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

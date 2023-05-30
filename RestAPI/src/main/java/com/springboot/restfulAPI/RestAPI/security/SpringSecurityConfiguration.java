package com.springboot.restfulAPI.RestAPI.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //We are overriding the default security behaviour
        //Default Steps
        //Step01: all requests will be authenticated.
        //Step02: If not authenticated, A login UI will be generated.
        //Step03: CSRF is implemented.

        //We need to override this behaviour
        //Whenever we need to change the security filter, entire implementation will be removed.
        //So need to implement everything from start.

        //To-DO [ Done ]

        //Step01: Check if all incoming requests are authenticated.
            //While wiring the api with a react app, if we have spring security, all incoming requests should be authenticated.
            //Either change the security config to allow Credentials or temporarily remove this condition.
        // In order to validate a preflight request, we need to permit the preflight request to any endpoint.
        //TO enable a preflight req(OPTIONS req) follow mwthod 02.

        //Method01->This will fail the preflight req
//        http.authorizeHttpRequests(auth->auth
//                .anyRequest().authenticated());

        //Method02 -> Fixed the pre-flight req failure case
        http.authorizeHttpRequests(auth->auth
                .requestMatchers(HttpMethod.OPTIONS,"/**")
                .permitAll()
                .anyRequest().authenticated());

        //Step02: If not, instead of showing a UI page, show a prompt to login
        http.httpBasic(Customizer.withDefaults());

        //Rest APIs are stateless
        http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        //disable CSRF
        http.csrf(csrf->csrf.disable());

        return http.build();

        //instead of calling all these methods individually, we can chain them as follows
//        return http.authorizeHttpRequests(auth->auth.anyRequest()
//                        .authenticated())
//                .httpBasic(Customizer.withDefaults())
//                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .build();

        //Preflight request will be failed.
    }
}

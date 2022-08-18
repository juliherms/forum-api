package com.juliherms.forum.forum.config

import com.juliherms.forum.forum.security.JWTAuthenticationFilter
import com.juliherms.forum.forum.security.JWTLoginFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


@Configuration
@EnableWebSecurity
class SecurityConfiguration (
    private val configuration: AuthenticationConfiguration,
    private val jwtUtil: JWTUtil
) {

    @Bean
    fun filterChain(http: HttpSecurity) : SecurityFilterChain {
        http
            .csrf().disable()
            .authorizeHttpRequests()
            .antMatchers(HttpMethod.POST, "/login").permitAll()
            .antMatchers(HttpMethod.GET, "/swagger-ui/*").permitAll()
            .antMatchers(HttpMethod.GET, "/v3/api-docs/**").permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .addFilterBefore(
                JWTLoginFilter(authManager = configuration.authenticationManager, jwtUtil = jwtUtil),
                UsernamePasswordAuthenticationFilter::class.java
            )

        http.addFilterBefore(
            JWTAuthenticationFilter(jwtUtil = jwtUtil),
            UsernamePasswordAuthenticationFilter::class.java
        )

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        return  http.build()
    }

    fun encoder(): PasswordEncoder? {
        return BCryptPasswordEncoder()
    }
}
package com.juliherms.forum.forum.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class SecurityConfiguration () {

    @Bean
    fun filterChain(http: HttpSecurity) : SecurityFilterChain {
        return http.
        authorizeHttpRequests().
        anyRequest().
        authenticated().
        and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
        and().
        formLogin().disable().
        httpBasic().and().build()
    }

    fun encoder(): PasswordEncoder? {
        return BCryptPasswordEncoder()
    }
}
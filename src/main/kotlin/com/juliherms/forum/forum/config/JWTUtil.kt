package com.juliherms.forum.forum.config

import com.juliherms.forum.forum.service.UserService
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.GrantedAuthority
import org.springframework.stereotype.Component

@Component
class JWTUtil(
    private val userService: UserService
) {
    private val expiration: Long = 900000

    @Value("\${jwt.secret}")
    private lateinit var secret: String

    fun generateToken(username:String, authorities: MutableCollection<out GrantedAuthority>): String? {
       return null;
    }
}
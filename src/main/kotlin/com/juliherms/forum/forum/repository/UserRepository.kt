package com.juliherms.forum.forum.repository

import com.juliherms.forum.forum.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User,Long> {

    fun findByEmail(username: String?): User?
}
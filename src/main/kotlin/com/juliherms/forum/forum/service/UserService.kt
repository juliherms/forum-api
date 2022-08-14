package com.juliherms.forum.forum.service

import com.juliherms.forum.forum.model.User
import org.springframework.stereotype.Service

@Service
class UserService(var users: List<User>) {

    init {
        val user = User(
            name = "Juliherms",
            email = "juliherms@email.com",
            id = 1
        )
        users = listOf(user)
    }

    fun findById(id: Long): User {
        return users.stream().filter{
                u -> u.id == id
        }.findFirst().get()
    }
}

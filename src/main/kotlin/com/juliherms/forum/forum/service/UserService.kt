package com.juliherms.forum.forum.service

import com.juliherms.forum.forum.model.User
import com.juliherms.forum.forum.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val repository: UserRepository
) {

    fun findById(id: Long): User {
       return  repository.getReferenceById(id)
    }
}

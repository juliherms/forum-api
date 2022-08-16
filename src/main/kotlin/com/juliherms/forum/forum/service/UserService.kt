package com.juliherms.forum.forum.service

import com.juliherms.forum.forum.dto.CourseView
import com.juliherms.forum.forum.dto.NewCourseForm
import com.juliherms.forum.forum.dto.NewUserForm
import com.juliherms.forum.forum.dto.UserView
import com.juliherms.forum.forum.mapper.NewUserMapper
import com.juliherms.forum.forum.mapper.UserViewMapper
import com.juliherms.forum.forum.model.User
import com.juliherms.forum.forum.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class UserService(
    private val repository: UserRepository,
    private val newUserMapper: NewUserMapper,
    private val userViewMapper: UserViewMapper
) {

    fun findById(id: Long): User {
       return  repository.getReferenceById(id)
    }

    fun list(): List<UserView> {
        return repository.findAll().stream().map {
                t -> userViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun create(newUserForm: NewUserForm): UserView {
        val user = newUserMapper.map(newUserForm)
        repository.save(user)
        return userViewMapper.map(user)
    }
}

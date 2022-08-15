package com.juliherms.forum.forum.mapper

import com.juliherms.forum.forum.dto.NewUserForm
import com.juliherms.forum.forum.model.User
import org.springframework.stereotype.Component

@Component
class NewUserMapper: Mapper<NewUserForm, User> {
    override fun map(t: NewUserForm): User {
        return User(
            email = t.email,
            name = t.name
        )
    }
}
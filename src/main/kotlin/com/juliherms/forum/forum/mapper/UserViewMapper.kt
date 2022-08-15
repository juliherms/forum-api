package com.juliherms.forum.forum.mapper

import com.juliherms.forum.forum.dto.UserView
import com.juliherms.forum.forum.model.User
import org.springframework.stereotype.Component

@Component
class UserViewMapper: Mapper<User,UserView> {
    override fun map(t: User): UserView {
        return UserView(
            id = t.id,
            name = t.name,
            email = t.email
        )
    }
}
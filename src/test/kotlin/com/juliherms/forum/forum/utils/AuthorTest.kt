package com.juliherms.forum.forum.utils

import com.juliherms.forum.forum.model.User

object AuthorTest {
    fun build() = User(
        id = 1,
        name = "user 1",
        email = "email@email.com",
        password = "12345"
    )
}
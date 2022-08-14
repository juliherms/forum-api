package com.juliherms.forum.forum.model

import java.time.LocalDateTime

data class Answer(
    val id: Long? = null,
    val message: String,
    val createdDate: LocalDateTime = LocalDateTime.now(),
    val author: User,
    val topic: Topic,
    val resolved: Boolean
)

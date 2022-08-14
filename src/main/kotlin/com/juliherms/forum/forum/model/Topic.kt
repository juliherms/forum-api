package com.juliherms.forum.forum.model

import java.time.LocalDateTime

/**
 * This class responsible to represents a topic
 */
data class Topic(
    val id: Long? = null,
    val title: String,
    val message: String,
    val createdDate: LocalDateTime = LocalDateTime.now(),
    val course: Course,
    val author: User,
    val status: TopicStatus = TopicStatus.NO_RESPONSE,
    val answers: List<Answer> = ArrayList()

)

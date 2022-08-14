package com.juliherms.forum.forum.dto

import com.juliherms.forum.forum.model.TopicStatus
import java.time.LocalDateTime

data class TopicView (
    val id: Long?,
    val title: String,
    val message: String,
    val status: TopicStatus,
    val createdDate: LocalDateTime
)

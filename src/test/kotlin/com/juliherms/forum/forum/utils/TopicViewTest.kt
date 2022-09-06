package com.juliherms.forum.forum.utils

import com.juliherms.forum.forum.dto.TopicView
import com.juliherms.forum.forum.model.TopicStatus
import java.time.LocalDateTime

object TopicViewTest {
    fun build() = TopicView(
        id = 1,
        title = "Kotlin Basic",
        message = "Learning Kotlin Basic",
        status = TopicStatus.NO_RESPONSE,
        createdDate = LocalDateTime.now()
    )
}
package com.juliherms.forum.forum.utils

import com.juliherms.forum.forum.model.Topic

object TopicTest {
    fun build() = Topic(
        id = 1,
        title = "Kotlin Basic",
        message = "Learning Basic Kotlin",
        course = CourseTest.build(),
        author = AuthorTest.build()
    )
}
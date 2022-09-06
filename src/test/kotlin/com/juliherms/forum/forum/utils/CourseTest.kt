package com.juliherms.forum.forum.utils

import com.juliherms.forum.forum.model.Course

object CourseTest {
    fun build() = Course(
        id = 1,
        name = "Kotlin",
        category = "Programacao"
    )
}
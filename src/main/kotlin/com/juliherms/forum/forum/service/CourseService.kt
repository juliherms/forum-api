package com.juliherms.forum.forum.service

import com.juliherms.forum.forum.model.Course
import org.springframework.stereotype.Service

@Service
class CourseService(var courses: List<Course>) {

    init {
        val course = Course(
            id = 1,
            name = "Kotlin",
            category = ""
        )
        courses = listOf(course)
    }

    fun findById(id: Long): Course {
        return courses.stream().filter{
            c -> c.id == id
        }.findFirst().get()
    }
}

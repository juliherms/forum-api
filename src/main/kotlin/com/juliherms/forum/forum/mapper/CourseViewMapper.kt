package com.juliherms.forum.forum.mapper

import com.juliherms.forum.forum.dto.CourseView
import com.juliherms.forum.forum.model.Course
import org.springframework.stereotype.Component

@Component
class CourseViewMapper: Mapper<Course, CourseView> {
    override fun map(t: Course): CourseView {
        return CourseView(
            id = t.id,
            name = t.name,
            category = t.category
        )
    }
}
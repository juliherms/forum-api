package com.juliherms.forum.forum.mapper

import com.juliherms.forum.forum.dto.NewCourseForm
import com.juliherms.forum.forum.model.Course
import org.springframework.stereotype.Component

@Component
class NewCourseMapper : Mapper<NewCourseForm, Course> {
    override fun map(t: NewCourseForm): Course {
       return Course(
           name = t.name,
           category = t.category
       )
    }
}
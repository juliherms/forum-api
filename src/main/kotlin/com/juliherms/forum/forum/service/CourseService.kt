package com.juliherms.forum.forum.service

import com.juliherms.forum.forum.dto.CourseView
import com.juliherms.forum.forum.dto.NewCourseForm
import com.juliherms.forum.forum.mapper.CourseViewMapper
import com.juliherms.forum.forum.mapper.NewCourseMapper
import com.juliherms.forum.forum.model.Course
import com.juliherms.forum.forum.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(
    private val repository:CourseRepository,
    private val newCourseMapper: NewCourseMapper,
    private val courseViewMapper: CourseViewMapper) {

    fun findById(id: Long): Course {
        return repository.getReferenceById(id)
    }

    fun create(newCourseForm: NewCourseForm): CourseView {
        val course = newCourseMapper.map(newCourseForm)
        repository.save(course)
        return courseViewMapper.map(course)
    }
}

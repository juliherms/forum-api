package com.juliherms.forum.forum.service

import com.juliherms.forum.forum.dto.CourseView
import com.juliherms.forum.forum.dto.NewCourseForm
import com.juliherms.forum.forum.mapper.CourseViewMapper
import com.juliherms.forum.forum.mapper.NewCourseMapper
import com.juliherms.forum.forum.model.Course
import com.juliherms.forum.forum.repository.CourseRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class CourseService(
    private val repository:CourseRepository,
    private val newCourseMapper: NewCourseMapper,
    private val courseViewMapper: CourseViewMapper) {

    fun findById(id: Long): Course {
        return repository.getReferenceById(id)
    }

    fun list(): List<CourseView> {
        return repository.findAll().stream().map {
                t -> courseViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun create(newCourseForm: NewCourseForm): CourseView {
        val course = newCourseMapper.map(newCourseForm)
        repository.save(course)
        return courseViewMapper.map(course)
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }
}

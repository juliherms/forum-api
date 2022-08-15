package com.juliherms.forum.forum.service

import com.juliherms.forum.forum.model.Course
import com.juliherms.forum.forum.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(private val repository:CourseRepository) {

    fun findById(id: Long): Course {
        return repository.getReferenceById(id)
    }
}

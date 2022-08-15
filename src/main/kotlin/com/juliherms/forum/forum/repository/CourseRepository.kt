package com.juliherms.forum.forum.repository

import com.juliherms.forum.forum.model.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository: JpaRepository<Course,Long> {
}
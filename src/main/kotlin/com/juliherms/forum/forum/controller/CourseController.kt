package com.juliherms.forum.forum.controller

import com.juliherms.forum.forum.dto.CourseView
import com.juliherms.forum.forum.dto.NewCourseForm
import com.juliherms.forum.forum.dto.NewTopicForm
import com.juliherms.forum.forum.dto.TopicView
import com.juliherms.forum.forum.service.CourseService
import com.juliherms.forum.forum.service.TopicService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.transaction.Transactional
import javax.validation.Valid

@RestController
@RequestMapping("/courses")
class CourseController(private val service: CourseService) {

    @GetMapping
    fun list(): List<CourseView> {
        return service.list()
    }

    @PostMapping
    @Transactional
    fun create(@RequestBody @Valid newCourseForm: NewCourseForm,
               uriBuilder: UriComponentsBuilder
    ): ResponseEntity<CourseView> {
        val courseView = service.create(newCourseForm)
        val uri = uriBuilder.path("/courses/${courseView.id}").build().toUri()
        return ResponseEntity.created(uri).body(courseView)
    }
}
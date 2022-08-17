package com.juliherms.forum.forum.controller

import com.juliherms.forum.forum.dto.CourseView
import com.juliherms.forum.forum.dto.NewCourseForm
import com.juliherms.forum.forum.service.CourseService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.transaction.Transactional
import javax.validation.Valid

@RestController
@RequestMapping("/courses")
class CourseController(private val service: CourseService) {

    @GetMapping
    @Cacheable("courses")
    fun list(): List<CourseView> {
        return service.list()
    }

    @PostMapping
    @Transactional
    @CacheEvict(value =["courses"], allEntries = true)
    fun create(@RequestBody @Valid newCourseForm: NewCourseForm,
               uriBuilder: UriComponentsBuilder
    ): ResponseEntity<CourseView> {
        val courseView = service.create(newCourseForm)
        val uri = uriBuilder.path("/courses/${courseView.id}").build().toUri()
        return ResponseEntity.created(uri).body(courseView)
    }
}
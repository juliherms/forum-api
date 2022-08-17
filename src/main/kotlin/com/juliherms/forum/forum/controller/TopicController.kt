package com.juliherms.forum.forum.controller

import com.juliherms.forum.forum.dto.NewTopicForm
import com.juliherms.forum.forum.dto.TopicView
import com.juliherms.forum.forum.dto.UpdateTopicForm
import com.juliherms.forum.forum.service.TopicService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import javax.transaction.Transactional
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    /**
     * http://localhost:8080/topics
     * http://localhost:8080/topics?courseName=test
     * http://localhost:8080/topics?size=5
     * http://localhost:8080/topics?size=5&page=1
     * http://localhost:8080/topics?sort=id,desc
     * http://localhost:8080/topics?sort=id,desc&sort=title
     */
    @GetMapping
    fun list(
        @RequestParam(required = false) courseName: String?,
        @PageableDefault(size = 5, sort = ["createdDate"], direction = Sort.Direction.DESC) pageable: Pageable
    ): Page<TopicView> {
       return service.list(courseName,pageable)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): TopicView {
        return service.findById(id)
    }

    @PostMapping
    @Transactional
    fun create(@RequestBody @Valid dto: NewTopicForm,
               uriBuilder:UriComponentsBuilder): ResponseEntity<TopicView> {
        val topicView = service.create(dto)
        val uri = uriBuilder.path("/topics/${topicView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicView)
    }

    @PutMapping
    @Transactional
    fun update(@RequestBody @Valid dto: UpdateTopicForm): ResponseEntity<TopicView> {
        val topicView = service.update(dto)
        return ResponseEntity.ok(topicView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun delete(@PathVariable id: Long){
        service.delete(id)
    }
}
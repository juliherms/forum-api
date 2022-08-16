package com.juliherms.forum.forum.controller

import com.juliherms.forum.forum.dto.NewUserForm
import com.juliherms.forum.forum.dto.UserView
import com.juliherms.forum.forum.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.transaction.Transactional
import javax.validation.Valid

@RestController
@RequestMapping("/users")
class UserController(private val service: UserService) {

    @GetMapping
    fun list(): List<UserView> {
        return service.list()
    }

    @PostMapping
    @Transactional
    fun create(@RequestBody @Valid newUserForm: NewUserForm,
               uriBuilder: UriComponentsBuilder
    ): ResponseEntity<UserView> {
        val userView = service.create(newUserForm)
        val uri = uriBuilder.path("/users/${userView.id}").build().toUri()
        return ResponseEntity.created(uri).body(userView)
    }
}
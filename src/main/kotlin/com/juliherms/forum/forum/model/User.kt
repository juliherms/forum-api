package com.juliherms.forum.forum.model

import javax.persistence.*

@Entity
@Table(name="TB_USER")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val email: String
)

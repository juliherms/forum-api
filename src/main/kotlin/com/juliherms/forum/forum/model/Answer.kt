package com.juliherms.forum.forum.model

import java.time.LocalDateTime
import javax.naming.Name
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name="TB_ANSWER")
data class Answer(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val message: String,
    val createdDate: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val author: User,
    @ManyToOne
    val topic: Topic,
    val resolved: Boolean
)

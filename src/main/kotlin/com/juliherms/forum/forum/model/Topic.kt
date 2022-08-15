package com.juliherms.forum.forum.model

import java.time.LocalDateTime
import javax.persistence.*

/**
 * This class responsible to represents a topic
 */
@Entity
@Table(name="TB_TOPIC")
data class Topic(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var title: String,
    var message: String,
    val createdDate: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val course: Course,
    @ManyToOne
    val author: User,
    @Enumerated(value = EnumType.STRING)
    val status: TopicStatus = TopicStatus.NO_RESPONSE,
    @OneToMany(mappedBy = "topic")
    val answers: List<Answer> = ArrayList()
)

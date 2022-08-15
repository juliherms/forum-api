package com.juliherms.forum.forum.dto

/**
 * Class responsible to represents input
 */
data class NewTopicForm(
    val title: String,
    val message: String,
    val idCourse: Long,
    val idAuthor: Long
)

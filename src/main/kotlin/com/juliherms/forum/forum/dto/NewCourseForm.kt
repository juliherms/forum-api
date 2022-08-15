package com.juliherms.forum.forum.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class NewCourseForm (
    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val name: String,
    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val category: String,
)
package com.juliherms.forum.forum.mapper

import com.juliherms.forum.forum.dto.NewTopicDTO
import com.juliherms.forum.forum.model.Topic
import com.juliherms.forum.forum.service.CourseService
import com.juliherms.forum.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class NewTopicDTOMapper(
    private val courseService: CourseService,
    private val userService: UserService
    ): Mapper<NewTopicDTO,Topic> {
    override fun map(t: NewTopicDTO): Topic {

        return Topic(
            title = t.title,
            message = t.message,
            course = courseService.findById(t.idCourse),
            author = userService.findById(t.idAuthor)
        )
    }
}

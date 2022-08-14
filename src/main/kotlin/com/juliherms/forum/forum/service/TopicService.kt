package com.juliherms.forum.forum.service

import com.juliherms.forum.forum.dto.NewTopicDTO
import com.juliherms.forum.forum.dto.TopicView
import com.juliherms.forum.forum.model.Topic
import org.springframework.stereotype.Service
import java.util.Collections
import java.util.stream.Collectors

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val courseService: CourseService,
    private val userService: UserService,
) {

    fun list(): List<TopicView> {

        return topics.stream().map { t ->
            TopicView(
                id = t.id,
                title = t.title,
                message = t.message,
                createdDate = t.createdDate,
                status = t.status
            )
        }.collect(Collectors.toList())
    }

    fun findById(id: Long): TopicView {
        val topic =  topics.stream().filter{
                t -> t.id == id
        }.findFirst().get()

        return TopicView(
            id = topic.id,
            title = topic.title,
            message = topic.message,
            createdDate = topic.createdDate,
            status = topic.status
        )
    }

    fun create(dto: NewTopicDTO) {

        topics = topics.plus(Topic(
            id = topics.size.toLong() + 1,
            title = dto.title,
            message = dto.message,
            course = courseService.findById(dto.idCourse),
            author = userService.findById(dto.idAuthor)
            )
        )
    }
}
package com.juliherms.forum.forum.service

import com.juliherms.forum.forum.dto.NewTopicForm
import com.juliherms.forum.forum.dto.TopicView
import com.juliherms.forum.forum.dto.UpdateTopicForm
import com.juliherms.forum.forum.mapper.TopicViewMapper
import com.juliherms.forum.forum.model.Topic
import com.juliherms.forum.forum.mapper.NewTopicDTOMapper
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val topicViewMapper: TopicViewMapper,
    private val newTopicDTOMapper: NewTopicDTOMapper,
) {

    fun list(): List<TopicView> {

        return topics.stream().map {
                t -> topicViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun findById(id: Long): TopicView {
        val topic =  topics.stream().filter{
                t -> t.id == id
        }.findFirst().get()

        return topicViewMapper.map(topic)
    }

    fun create(form: NewTopicForm) {
        val topic = newTopicDTOMapper.map(form)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
    }

    fun update(dto: UpdateTopicForm) {
        val topic = topics.stream().filter{
            t -> t.id == dto.id
        }.findFirst().get()

        topics = topics.minus(topic).plus(Topic(
            id = dto.id,
            title = dto.title,
            message = dto.message,
            author = topic.author,
            course = topic.course,
            answers = topic.answers,
            status = topic.status,
            createdDate = topic.createdDate
        ))
    }
}
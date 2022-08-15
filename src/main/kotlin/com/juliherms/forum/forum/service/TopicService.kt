package com.juliherms.forum.forum.service

import com.juliherms.forum.forum.dto.NewTopicForm
import com.juliherms.forum.forum.dto.TopicView
import com.juliherms.forum.forum.dto.UpdateTopicForm
import com.juliherms.forum.forum.exception.NotFoundException
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
    private val notFoundMessage: String = "Topic not found"
) {

    fun list(): List<TopicView> {

        return topics.stream().map {
                t -> topicViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun findById(id: Long): TopicView {
        val topic =  topics.stream().filter{
                t -> t.id == id
        }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}

        return topicViewMapper.map(topic)
    }

    fun create(form: NewTopicForm): TopicView {
        val topic = newTopicDTOMapper.map(form)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
        return topicViewMapper.map(topic)
    }

    fun update(dto: UpdateTopicForm): TopicView {
        val topic = topics.stream().filter{
            t -> t.id == dto.id
        }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}

        val updatedTopic = Topic(
            id = dto.id,
            title = dto.title,
            message = dto.message,
            author = topic.author,
            course = topic.course,
            answers = topic.answers,
            status = topic.status,
            createdDate = topic.createdDate
        )

        topics = topics.minus(topic).plus(updatedTopic)

        return topicViewMapper.map(updatedTopic)
    }

    fun delete(id: Long) {
        val topic = topics.stream().filter{
                t -> t.id == id
        }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}
        topics = topics.minus(topic)
    }
}
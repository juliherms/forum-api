package com.juliherms.forum.forum.service

import com.juliherms.forum.forum.dto.NewTopicForm
import com.juliherms.forum.forum.dto.TopicView
import com.juliherms.forum.forum.dto.UpdateTopicForm
import com.juliherms.forum.forum.exception.NotFoundException
import com.juliherms.forum.forum.mapper.TopicViewMapper
import com.juliherms.forum.forum.model.Topic
import com.juliherms.forum.forum.mapper.NewTopicDTOMapper
import com.juliherms.forum.forum.repository.TopicRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService(
    private val repository: TopicRepository,
    private val topicViewMapper: TopicViewMapper,
    private val newTopicDTOMapper: NewTopicDTOMapper,
    private val notFoundMessage: String = "Topic not found"
) {

    fun list(courseName: String?,
             pageable: Pageable): Page<TopicView> {

        val topics = if(courseName == null){
            repository.findAll(pageable)
        } else {
            repository.findByCourseName(courseName,pageable)
        }

        return topics.map { t ->
            topicViewMapper.map(t)
        }
    }

    fun findById(id: Long): TopicView {

        val topic = repository.findById(id)
            .orElseThrow{NotFoundException(notFoundMessage)}
        return topicViewMapper.map(topic)
    }

    fun create(form: NewTopicForm): TopicView {
        val topic = newTopicDTOMapper.map(form)
        repository.save(topic)
        return topicViewMapper.map(topic)
    }

    fun update(dto: UpdateTopicForm): TopicView {
        val topic = repository.findById(dto.id)
            .orElseThrow{NotFoundException(notFoundMessage)}

        topic.title = dto.title
        topic.message = dto.message

        return topicViewMapper.map(topic)
    }

    fun delete(id: Long) {
       repository.deleteById(id)
    }
}
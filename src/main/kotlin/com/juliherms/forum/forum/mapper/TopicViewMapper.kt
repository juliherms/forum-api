package com.juliherms.forum.forum.mapper

import com.juliherms.forum.forum.dto.TopicView
import com.juliherms.forum.forum.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper: Mapper<Topic,TopicView> {

    override fun map(t: Topic): TopicView {
        return TopicView(
            id = t.id,
            title = t.title,
            message = t.message,
            createdDate = t.createdDate,
            status = t.status
        )
    }
}
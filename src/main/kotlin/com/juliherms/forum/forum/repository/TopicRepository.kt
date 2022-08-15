package com.juliherms.forum.forum.repository

import com.juliherms.forum.forum.model.Topic
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository:JpaRepository<Topic,Long> {

}
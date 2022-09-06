package com.juliherms.forum.forum.service

import com.juliherms.forum.forum.exception.NotFoundException
import com.juliherms.forum.forum.mapper.NewTopicDTOMapper
import com.juliherms.forum.forum.mapper.TopicViewMapper
import com.juliherms.forum.forum.repository.TopicRepository
import com.juliherms.forum.forum.utils.TopicTest
import com.juliherms.forum.forum.utils.TopicViewTest
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import java.util.*

/**
 * This class responsible to test topicService
 */
class TopicServiceTest {

    val topics = PageImpl(
        listOf(
            TopicTest.build()
        )
    )

    val pagination: Pageable = mockk()

    //simulate return for findByCourse
    val topicRepository: TopicRepository = mockk {
        every { findByCourseName(any(),any()) } returns topics
        every { findAll(pagination) } returns topics

    }

    val topicViewMapper: TopicViewMapper = mockk{
        every { map(any()) } returns TopicViewTest.build()
    }

    val newTopicDTOMapper: NewTopicDTOMapper = mockk()

    val topicService = TopicService(
        topicRepository, topicViewMapper, newTopicDTOMapper
    )

    @Test
    fun `when find topic by course name - returns topic`(){
       topicService.list("Kotlin Advanced",pagination)
        verify(exactly = 1) { topicRepository.findByCourseName(any(),any())}
        verify(exactly = 1) { topicViewMapper.map(any())}
        verify(exactly = 0) { topicRepository.findAll(pagination) }
    }

    @Test
    fun `when find topic and course name is empty - return list of topics`() {
        topicService.list(null,pagination)
        verify(exactly = 0) { topicRepository.findByCourseName(any(),any())}
        verify(exactly = 1) { topicViewMapper.map(any())}
        verify(exactly = 1) { topicRepository.findAll(pagination) }
    }

    @Test
    fun `when find by topic id - returns not found exception`(){
        every { topicRepository.findById(any()) } returns Optional.empty()

        val actual = assertThrows<NotFoundException> {
            topicService.findById(1)
        }
        assertThat(actual.message).isEqualTo("Topic not found")
    }

}
package com.example.redditclone.viewmodel

import com.example.redditclone.common.CashManager
import com.example.redditclone.models.Topic
import org.junit.Before
import org.junit.Test

class TopicsViewModelTest {

    /**
     * since the app logic is very simple and we don't have repository no need to using Mockito
     * */

    private lateinit var viewModel: TopicsViewModel

    @Before
    fun setUp() {
        viewModel = TopicsViewModel()
        CashManager.topicsMap.clear()
        CashManager.topicsMap[1] = Topic(1, "topic 1", 1)
        CashManager.topicsMap[2] = Topic(2, "topic 2", 2)
    }

    @Test
    fun getTopicsSortedCorrectly() {
        val topics = viewModel.getTopics()
        assert(topics[0].id == 2)
        assert(topics[1].id == 1)
    }

    @Test
    fun getTopicsLimitedTo_20() {
        for (i in 0 until 30) {
            CashManager.topicsMap[i] = Topic(i, "topic $i", i)
        }
        val topics = viewModel.getTopics()
        assert(topics.size == 20)
    }

    @Test
    fun `upVote And Check New Order`() {
        viewModel.upVote(1)
        viewModel.upVote(1)

        val topics = viewModel.getTopics()
        assert(topics[0].id == 1)
        assert(topics[1].id == 2)
    }

    @Test
    fun `downVote And Check New Order`() {
        viewModel.upVote(2)
        viewModel.upVote(2)

        val topics = viewModel.getTopics()
        assert(topics[0].id == 2)
        assert(topics[1].id == 1)
    }

    @Test
    fun addTopic() {
        viewModel.addTopic(Topic(3, "topic 3"))
        assert(CashManager.topicsMap.contains(3))
    }

    @Test
    fun getTopic() {
        val topicInCash = CashManager.topicsMap[1]
        val topic = viewModel.getTopic(1)

        assert(topic?.id == topicInCash?.id)
        assert(topic?.content == topicInCash?.content)
        assert(topic?.votes == topicInCash?.votes)
    }
}
package com.example.redditclone.viewmodel

import androidx.lifecycle.ViewModel
import com.example.redditclone.common.CashManager
import com.example.redditclone.models.Topic

class TopicsViewModel : ViewModel() {

    /**
     * Always return a list of top 20 topics (sorted by upvotes, descending)
     * */
    fun getTopics(): List<Topic> {
        return CashManager.topicsMap.values.toList().sortedByDescending { it.votes }.take(20)
    }

    /**
     * upVote a topic by id
     * */
    fun upVote(id: Int) {
        CashManager.topicsMap[id] = CashManager.topicsMap[id]!!.apply { votes++ }
    }

    /**
     * downVote a topic by id
     * */
    fun downVote(id: Int) {
        CashManager.topicsMap[id] = CashManager.topicsMap[id]!!.apply { if (votes > 0) votes-- }
    }

    fun addTopic(topic: Topic) {
        CashManager.topicsMap[topic.id] = topic
    }

    /**
     * retrieves a single topic
     * */
    fun getTopic(id: Int): Topic? {
        return CashManager.topicsMap[id]
    }
}
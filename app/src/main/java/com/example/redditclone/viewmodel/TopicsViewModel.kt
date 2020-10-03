package com.example.redditclone.viewmodel

import com.example.redditclone.common.CashManager
import com.example.redditclone.models.Topic

class TopicsViewModel {

    /**
     * Always return a list of top 20 topics (sorted by upvotes, descending)
     * */
    fun getTopics(): List<Topic> {
        return CashManager.topicsList.values.toList().sortedByDescending { it.votes }.take(20)
    }

    fun upVote(id: Int) {
        CashManager.topicsList[id] = CashManager.topicsList[id]!!.apply { votes++ }
    }

    fun downVote(id: Int) {
        CashManager.topicsList[id] = CashManager.topicsList[id]!!.apply { if (votes > 0) votes-- }
    }

    fun addTopic(topic: Topic) {
        CashManager.topicsList[topic.id] = topic
    }
}
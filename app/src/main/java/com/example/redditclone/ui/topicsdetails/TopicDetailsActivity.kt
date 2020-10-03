package com.example.redditclone.ui.topicsdetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.redditclone.R
import com.example.redditclone.databinding.ActivityTopicDetailsBinding
import com.example.redditclone.viewmodel.TopicsViewModel

class TopicDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTopicDetailsBinding
    private val topicsViewModel by lazy { TopicsViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_topic_details)
        setUpUI(intent.getIntExtra(TOPIC_ID, 0))
    }

    private fun setUpUI(id: Int) {
        binding.topic = topicsViewModel.getTopic(id)

        binding.downVote.setOnClickListener {
            topicsViewModel.downVote(id)
            binding.topic = topicsViewModel.getTopic(id)
        }

        binding.upVote.setOnClickListener {
            topicsViewModel.upVote(id)
            binding.topic = topicsViewModel.getTopic(id)
        }
    }

    companion object {
        const val TOPIC_ID = "topic_id"
    }
}
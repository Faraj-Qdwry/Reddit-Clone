package com.example.redditclone.topics

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.redditclone.AddTopicActivity
import com.example.redditclone.R
import com.example.redditclone.databinding.ActivityTopicsBinding
import com.example.redditclone.viewmodel.TopicsViewModel
import kotlinx.android.synthetic.main.activity_topics.*

class TopicsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTopicsBinding

    private val topicsViewModel by lazy { TopicsViewModel() }

    private val topicsAdapter by lazy {
        TopicsAdapter({
            topicsViewModel.upVote(it)
            refreshTopicsData()
        }) {
            topicsViewModel.downVote(it)
            refreshTopicsData()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_topics)
        setupTopicsUi()
        setUpClickListeners()
    }

    private fun setUpClickListeners() {
        add_topic.setOnClickListener {
            startActivity(Intent(this, AddTopicActivity::class.java))
        }
    }

    private fun setupTopicsUi() {
        binding.topicsRecyclerView.adapter = topicsAdapter
    }

    private fun refreshTopicsData() {
        topicsAdapter.setData(topicsViewModel.getTopics())
    }

    override fun onResume() {
        super.onResume()
        refreshTopicsData()
    }
}
package com.example.redditclone.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.redditclone.R
import com.example.redditclone.databinding.ActivityTopicDetailsBinding

class TopicDetails : AppCompatActivity() {
    private lateinit var binding: ActivityTopicDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_topic_details)
    }
}
package com.example.redditclone.topics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.redditclone.R
import com.example.redditclone.databinding.ActivityTopicsBinding

class TopicsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTopicsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_topics)
    }
}
package com.example.redditclone.ui.addtopics

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.redditclone.R
import com.example.redditclone.databinding.ActivityAddTopicBinding
import com.example.redditclone.models.Topic
import com.example.redditclone.viewmodel.TopicsViewModel
import kotlin.random.Random

class AddTopicActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddTopicBinding
    private val topicsViewModel by lazy { TopicsViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_topic)
        setUpInputFieldTextWatcher()
        setUpClickListeners()
    }

    private fun setUpClickListeners() {
        binding.addTopic.setOnClickListener {
            topicsViewModel.addTopic(Topic(Random.nextInt(), binding.topicEditText.text.toString()))
            finish()
        }
    }

    private fun setUpInputFieldTextWatcher() {
        binding.topicEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(text: CharSequence, start: Int, before: Int, count: Int) {
                binding.charCount = text.length
            }
        })
    }
}
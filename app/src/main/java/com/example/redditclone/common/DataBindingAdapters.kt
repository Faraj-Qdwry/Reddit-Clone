package com.example.redditclone.common

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.databinding.BindingAdapter


object DataBindingAdapters {

    @JvmStatic
    @BindingAdapter("android:setVotes")
    fun setVotes(textView: TextView, votes: Int) {
        textView.text = "$votes"
    }

    @SuppressLint("SetTextI18n")
    @JvmStatic
    @BindingAdapter("android:setTopicCharCount")
    fun setTopicCharCount(textView: TextView, count: Int) {
        textView.text = "$count/255"
    }
}
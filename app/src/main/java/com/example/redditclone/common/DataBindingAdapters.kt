package com.example.redditclone.common

import android.widget.TextView
import androidx.databinding.BindingAdapter


object DataBindingAdapters {

    @JvmStatic
    @BindingAdapter("android:setVotes")
    fun setVotes(textView: TextView, votes: Int) {
        textView.text = "$votes"
    }
}
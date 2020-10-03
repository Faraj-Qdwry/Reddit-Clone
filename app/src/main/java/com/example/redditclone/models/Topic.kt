package com.example.redditclone.models

data class Topic(
    val id: Int,
    var content: String,
    var votes: Int = 0
)

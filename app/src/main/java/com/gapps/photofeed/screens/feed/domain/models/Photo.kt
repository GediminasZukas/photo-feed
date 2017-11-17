package com.gapps.photofeed.screens.feed.domain.models

data class Photo constructor(val photoUrl: String,
                             val photoTitle: String,
                             val authorAvatarUrl: String,
                             var authorName: String)
package com.gapps.photofeed.screens.feed.presentation.models

data class PhotoModel constructor(val photoUrl: String,
                                  val photoTitle: String,
                                  val authorAvatarUrl: String,
                                  val authorName: String)
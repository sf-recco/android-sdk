package com.shadowflight.core.model.feed

data class FeedSection(
    val type: FeedSectionType,
    val state: FeedSectionState,
    val topic: Topic?
)

package com.stanislav.presentation_post.list

import com.stanislav.presentation_common.state.UiSingleEvent

sealed class PostListUiSingleEvent : UiSingleEvent {
    data class OpenUserScreen(val navRoute: String) : PostListUiSingleEvent()
    data class OpenPostScreen(val navRoute: String) : PostListUiSingleEvent()
}
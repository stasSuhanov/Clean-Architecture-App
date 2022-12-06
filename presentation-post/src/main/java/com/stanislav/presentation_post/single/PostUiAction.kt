package com.stanislav.presentation_post.single

import com.stanislav.presentation_common.state.UiAction

sealed class PostUiAction : UiAction {
    data class Load(val postId: Long) : PostUiAction()
}
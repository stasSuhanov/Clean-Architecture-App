package com.stanislav.presentation_user.single

import com.stanislav.presentation_common.state.UiAction

sealed class UserUiAction : UiAction {
    data class Load(val userId: Long) : UserUiAction()
}
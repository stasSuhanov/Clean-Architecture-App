package com.stanislav.presentation_user.single

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.stanislav.presentation_common.navigation.UserInput
import com.stanislav.presentation_common.state.CommonScreen

@Composable
fun UserScreen(viewModel: UserViewModel, userInput: UserInput) {
    LaunchedEffect(userInput.userId) { viewModel.submitAction(UserUiAction.Load(userInput.userId)) }
    viewModel.uiStateFlow.collectAsState().value.let { result ->
        CommonScreen(result) { userModel -> User(userModel) }
    }
}

@Composable
fun User(userModel: UserModel) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = userModel.name)
        Text(text = userModel.username)
        Text(text = userModel.email)
    }
}
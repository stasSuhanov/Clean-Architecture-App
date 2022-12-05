package com.stanislav.presentation_post.list

import android.content.Context
import com.stanislav.domain.usecase.GetPostsWithUsersWithInteractionUseCase
import com.stanislav.presentation_common.state.CommonResultConverter
import com.stanislav.presentation_post.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PostListConverter @Inject constructor(
    @ApplicationContext private val context: Context
) : CommonResultConverter<GetPostsWithUsersWithInteractionUseCase.Response, PostListModel>() {

    override fun convertSuccess(data: GetPostsWithUsersWithInteractionUseCase.Response): PostListModel {
        return PostListModel(
            headerText = context.getString(
                R.string.total_click_count,
                data.interaction.totalClicks
            ),
            items = data.posts.map {
                PostListItemModel(
                    it.post.id,
                    it.user.id,
                    context.getString(R.string.author, it.user.name),
                    context.getString(R.string.title, it.post.title),
                )
            },
            interaction = data.interaction,
        )
    }
}
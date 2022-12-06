package com.stanislav.domain.usecase

import com.stanislav.domain.entity.Post
import com.stanislav.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetPostUseCase constructor(
    configuration: Configuration,
    private val postRepository: PostRepository,
) : UseCase<GetPostUseCase.Request, GetPostUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> =
        postRepository.getPost(request.postId).map { Response(it) }

    data class Request(val postId: Long) : UseCase.Request
    data class Response(val post: Post) : UseCase.Response
}
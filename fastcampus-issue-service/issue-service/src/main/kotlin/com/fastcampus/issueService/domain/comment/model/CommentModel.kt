package com.fastcampus.issueService.domain.comment.model

import com.fastcampus.issueService.domain.comment.Comment

data class CommentRequest(
    val body: String,
)

data class CommentResponse(
    val id: Long,
    val userId: Long,
    val userName: String? = null,
    val issueId: Long,
    val body: String,
)

fun Comment.toResponse() = CommentResponse(
    id = id!!,
    issueId = issue.id!!,
    userId = userId,
    userName = userName,
    body = body,
)
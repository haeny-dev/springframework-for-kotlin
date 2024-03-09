package com.fastcampus.issueService.web

import com.fastcampus.issueService.domain.comment.model.CommentRequest
import com.fastcampus.issueService.domain.comment.service.CommentService
import com.fastcampus.issueService.global.config.AuthUser
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/issues/{issueId}/comments")
class CommentController(
    private val commentService: CommentService,
) {

    @PostMapping
    fun create(
        authUser: AuthUser,
        @PathVariable issueId: Long,
        @RequestBody request: CommentRequest,
    ) = commentService.create(
        issueId = issueId,
        userId = authUser.userId,
        userName = authUser.userName,
        request = request,
    )
}
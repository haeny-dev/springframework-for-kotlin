package com.fastcampus.issueService.domain.comment.service

import com.fastcampus.issueService.domain.comment.Comment
import com.fastcampus.issueService.domain.comment.model.CommentRequest
import com.fastcampus.issueService.domain.comment.model.CommentResponse
import com.fastcampus.issueService.domain.comment.model.toResponse
import com.fastcampus.issueService.domain.comment.repository.CommentRepository
import com.fastcampus.issueService.domain.issuse.repository.IssueRepository
import com.fastcampus.issueService.global.exception.NotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CommentService(
    private val commentRepository: CommentRepository,
    private val issueRepository: IssueRepository,
) {

    @Transactional
    fun create(
        issueId: Long,
        userId: Long,
        userName: String,
        request: CommentRequest,
    ): CommentResponse {
        val issue = issueRepository.findByIdOrNull(id = issueId)
            ?: throw NotFoundException("이슈가 존재하지 않습니다.")

        val comment = Comment(
            issue = issue,
            userId = userId,
            userName = userName,
            body = request.body,
        )

        issue.comments.add(comment)

        return commentRepository.save(comment).toResponse()
    }

    @Transactional
    fun edit(
        id: Long,
        userId: Long,
        request: CommentRequest,
    ): CommentResponse? =
        commentRepository.findByIdAndUserId(
            id = id,
            userId = userId
        )?.run {
            body = request.body
            commentRepository.save(this).toResponse()
        }

    @Transactional
    fun delete(
        issueId: Long,
        id: Long,
        userId: Long
    ) {
        val issue = issueRepository.findByIdOrNull(id = issueId)
            ?: throw NotFoundException("이슈가 존재하지 않습니다.")

        commentRepository.findByIdAndUserId(
            id = id,
            userId = userId,
        )?.let {
            issue.comments.remove(it)
        }
    }
}
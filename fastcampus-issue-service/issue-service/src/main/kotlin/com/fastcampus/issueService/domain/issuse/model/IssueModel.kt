package com.fastcampus.issueService.domain.issuse.model

import com.fastcampus.issueService.domain.comment.Comment
import com.fastcampus.issueService.domain.comment.model.CommentResponse
import com.fastcampus.issueService.domain.comment.model.toResponse
import com.fastcampus.issueService.domain.issuse.Issue
import com.fastcampus.issueService.domain.issuse.IssuePriority
import com.fastcampus.issueService.domain.issuse.IssueStatus
import com.fastcampus.issueService.domain.issuse.IssueType
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class IssueRequest(
    val summary: String,
    val description: String,
    val type: IssueType,
    val priority: IssuePriority,
    val status: IssueStatus,
)

data class IssueResponse(
    val id: Long,
    val userId: Long,
    val summary: String,
    val description: String,
    val type: IssueType,
    val priority: IssuePriority,
    val status: IssueStatus,
    val comments: List<CommentResponse> = emptyList(),
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val createdAt: LocalDateTime?,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val updatedAt: LocalDateTime?,
) {
    companion object {
        operator fun invoke(issue: Issue) =
            with(issue) {
                IssueResponse(
                    id = id!!,
                    userId = userId,
                    summary = summary,
                    description = description,
                    type = type,
                    priority = priority,
                    status = status,
                    comments = comments.sortedByDescending(Comment::id).map(Comment::toResponse),
                    createdAt = createdAt,
                    updatedAt = updatedAt
                )
            }
    }
}
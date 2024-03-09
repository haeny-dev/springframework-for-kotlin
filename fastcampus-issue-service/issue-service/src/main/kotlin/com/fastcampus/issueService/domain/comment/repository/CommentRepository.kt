package com.fastcampus.issueService.domain.comment.repository

import com.fastcampus.issueService.domain.comment.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<Comment, Long>

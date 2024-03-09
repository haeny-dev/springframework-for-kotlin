package com.fastcampus.issueService.domain.issuse.repository

import com.fastcampus.issueService.domain.issuse.Issue
import com.fastcampus.issueService.domain.issuse.IssueStatus
import org.springframework.data.jpa.repository.JpaRepository

interface IssueRepository : JpaRepository<Issue, Long> {
    fun findAllByStatusOrderByCreatedAtDesc(status: IssueStatus): List<Issue>?
}
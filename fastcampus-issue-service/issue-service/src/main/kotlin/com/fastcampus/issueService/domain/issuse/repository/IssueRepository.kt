package com.fastcampus.issueService.domain.issuse.repository

import com.fastcampus.issueService.domain.issuse.Issue
import org.springframework.data.jpa.repository.JpaRepository

interface IssueRepository : JpaRepository<Issue, Long> {
}
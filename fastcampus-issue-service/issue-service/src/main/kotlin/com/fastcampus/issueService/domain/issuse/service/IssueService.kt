package com.fastcampus.issueService.domain.issuse.service

import com.fastcampus.issueService.domain.issuse.Issue
import com.fastcampus.issueService.domain.issuse.model.IssueRequest
import com.fastcampus.issueService.domain.issuse.model.IssueResponse
import com.fastcampus.issueService.domain.issuse.repository.IssueRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class IssueService(
    private val issueRepository: IssueRepository,
) {

    @Transactional
    fun create(
        userId: Long,
        request: IssueRequest
    ): IssueResponse {

        val issue = Issue(
            summary = request.summary,
            description = request.description,
            userId = userId,
            type = request.type,
            priority = request.priority,
            status = request.status,
        )

        return IssueResponse(issueRepository.save(issue))
    }
}
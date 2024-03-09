package com.fastcampus.issueService.web

import com.fastcampus.issueService.domain.issuse.model.IssueRequest
import com.fastcampus.issueService.domain.issuse.service.IssueService
import com.fastcampus.issueService.global.config.AuthUser
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/issues")
class IssueController(
    private val issueService: IssueService,
) {

    @PostMapping
    fun create(
        authUser: AuthUser,
        @RequestBody request: IssueRequest,
    ) = issueService.create(
        userId = authUser.userId,
        request = request,
    )
}
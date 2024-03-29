package com.fastcampus.issueService.web

import com.fastcampus.issueService.domain.issuse.IssueStatus
import com.fastcampus.issueService.domain.issuse.model.IssueRequest
import com.fastcampus.issueService.domain.issuse.service.IssueService
import com.fastcampus.issueService.global.config.AuthUser
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
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

    @GetMapping
    fun getAll(
        authUser: AuthUser,
        @RequestParam(required = false, defaultValue = "TODO") status: IssueStatus,
    ) = issueService.getAll(status)

    @GetMapping("/{issueId}")
    fun get(
        authUser: AuthUser,
        @PathVariable issueId: Long,
    ) = issueService.get(issueId)

    @PutMapping("/{issueId}")
    fun edit(
        authUser: AuthUser,
        @PathVariable issueId: Long,
        @RequestBody request: IssueRequest,
    ) = issueService.edit(
        userId = authUser.userId,
        id = issueId,
        request = request
    )

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{issueId}")
    fun delete(
        authUser: AuthUser,
        @PathVariable issueId: Long,
    ) = issueService.delete(id = issueId)
}
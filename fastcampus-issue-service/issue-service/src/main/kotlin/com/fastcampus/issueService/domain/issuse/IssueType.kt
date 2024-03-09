package com.fastcampus.issueService.domain.issuse

enum class IssueType {
    BUG,
    TASK;

    companion object {
        operator fun invoke(type: String) = valueOf(type.uppercase())
    }
}

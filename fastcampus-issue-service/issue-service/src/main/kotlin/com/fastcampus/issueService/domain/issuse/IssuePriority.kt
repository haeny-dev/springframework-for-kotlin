package com.fastcampus.issueService.domain.issuse

enum class IssuePriority {
    LOW,
    MEDIUM,
    HIGH;

    companion object {
        operator fun invoke(priority: String) = valueOf(priority.uppercase())
    }
}

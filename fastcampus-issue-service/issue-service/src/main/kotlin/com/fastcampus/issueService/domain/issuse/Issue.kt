package com.fastcampus.issueService.domain.issuse

import com.fastcampus.issueService.domain.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table
class Issue(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    var userId: Long,

    @Column
    var summary: String,

    @Column
    var description: String,

    @Enumerated(EnumType.STRING)
    @Column
    var type: IssueType,

    @Enumerated(EnumType.STRING)
    @Column
    var priority: IssuePriority,

    @Enumerated(EnumType.STRING)
    @Column
    var status: IssueStatus,
) : BaseEntity()
package com.fastcampus.issueService.domain.comment

import com.fastcampus.issueService.domain.BaseEntity
import com.fastcampus.issueService.domain.issuse.Issue
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table
class Comment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issue_id")
    val issue: Issue,

    @Column
    val userId: Long,

    @Column
    val userName: String,

    @Column
    var body: String,
) : BaseEntity()
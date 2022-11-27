package io.eylo.taxi.api.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null

    @CreatedDate
    @Column(updatable = false)
    private val createdAt: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate
    private var updatedAt: LocalDateTime = LocalDateTime.now()
}

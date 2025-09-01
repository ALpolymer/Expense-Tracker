package dev.alexpol.expenseTracker.model;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity {

    @CreatedDate
    @Column(nullable = false, name="created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false, name="updated_at")
    private LocalDateTime updatedAt;
}
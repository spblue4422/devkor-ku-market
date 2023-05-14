package com.spblue4422.kumarket.entity.common;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@NoArgsConstructor
public class BaseEntity {
	@CreatedDate
	@Column(name = "createdAt", updatable = false)
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column(name = "updatedAt")
	private LocalDateTime updatedAt;

	@Column(name = "deletedAt")
	private LocalDateTime deletedAt;
}

package com.spblue4422.kumarket.entity.common;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class Image extends BaseEntity {
	@Column(name="originalName")
	protected String originalName;

	@Column(name="savedName")
	protected String savedName;

	@Column(name="savedPath")
	protected String savedPath;
}

package com.spblue4422.kumarket.entity;

import com.spblue4422.kumarket.entity.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@Entity(name="TB_Bookmark")
@AllArgsConstructor
@NoArgsConstructor
public class Bookmark extends BaseEntity {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bookmarkId")
	private Long bookmarkId;

	@ManyToOne()
	@JoinColumn(name="bookmark_user")
	private User user;

	@ManyToOne()
	@JoinColumn(name = "bookmark_post")
	private Post post;
}

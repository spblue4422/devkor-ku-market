package com.spblue4422.kumarket.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@Entity(name="TB_Bookmark")
@AllArgsConstructor
@NoArgsConstructor
public class BookMark {
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

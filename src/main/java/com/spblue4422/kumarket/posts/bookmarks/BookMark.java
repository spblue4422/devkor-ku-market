package com.spblue4422.kumarket.posts.bookmarks;

import com.spblue4422.kumarket.posts.Post;
import com.spblue4422.kumarket.users.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

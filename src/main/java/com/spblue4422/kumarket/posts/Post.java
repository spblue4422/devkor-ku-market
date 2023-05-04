package com.spblue4422.kumarket.posts;

import com.spblue4422.kumarket.users.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Builder
@Entity(name="TB_Post")
@AllArgsConstructor
@NoArgsConstructor
public class Post {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "postId")
	private Long postId;

	@ManyToOne()
	@JoinColumn(name="post_user")
	private User user;
	//enum
	@Column(name="category")
	@NotNull()
	private String category;

	@Column(name="title")
	@NotNull()
	private String title;

	@Column(name = "description")
	@NotNull()
	private String description;

	@Column(name="thumbnailUrl")
	@NotNull()
	private String thumbnailUrl;

	@Column(name = "price")
	private Integer price;

	@Column(name = "viewCount")
	private Integer viewCount;

	//enum
	@Column(name = "status")
	private String status;
}

package com.spblue4422.kumarket.posts;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

public class Post {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "postId")
	private Long postId;

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
}

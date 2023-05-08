package com.spblue4422.kumarket.dto.posts;

import lombok.*;

@Getter
@Builder
public class PostListItemDto {
	private Long postId;
	private String category;
	private String title;
	private String thumbnailUrl;
}

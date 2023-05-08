package com.spblue4422.kumarket.dto.posts;

import lombok.*;

@Getter
@Builder
public class PostResponseDto {
	private Long postId;
	private String category;
	private String title;
	private String description;
	private String thumbnailUrl;
	private Integer price;
	private Integer viewCount;

	//userInfo
	private Long userId;
	private String userName;
	private Integer likes;
}

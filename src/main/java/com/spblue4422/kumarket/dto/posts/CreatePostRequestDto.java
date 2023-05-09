package com.spblue4422.kumarket.dto.posts;

import lombok.*;

@Getter
@Builder
public class CreatePostRequestDto {
	private String category;
	private String title;
	private String description;
	private String thumbnailUrl;
	private Integer price;
	private Integer viewCount;
	private String status;
}

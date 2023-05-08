package com.spblue4422.kumarket.dto.posts;

import lombok.*;
import java.util.List;

@Getter
@Builder
public class PostListResponseDto {
	private List<PostListItemDto> postList;
	private Integer count;
}

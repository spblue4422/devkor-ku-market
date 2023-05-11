package com.spblue4422.kumarket.dto.posts;

import com.spblue4422.kumarket.entity.PostPhoto;
import lombok.*;

import java.util.List;

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
	private List<PostPhoto> postPhotoList;

	//userInfo
	private Long userId;
	private String userName;
	private Integer likes;
}

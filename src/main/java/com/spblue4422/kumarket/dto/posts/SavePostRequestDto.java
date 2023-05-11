package com.spblue4422.kumarket.dto.posts;

import com.spblue4422.kumarket.entity.Post;
import com.spblue4422.kumarket.entity.User;
import lombok.*;

import java.util.ArrayList;

@Getter
@Builder
public class SavePostRequestDto {
	private String category;
	private String title;
	private String description;
	private Integer price;
	private Integer viewCount;
	private String status;

	public Post toInsertPostEntity(User userData) {
		return Post.builder()
				.category(category)
				.title(title)
				.description(description)
				.thumbnailUrl(null)
				.price(price)
				.viewCount(0)
				.status("")
				.postPhotoList(new ArrayList<>())
				.build();
	}

	public Post toUpdatePostEntity(Post prevPost) {
		return Post.builder()
				.postId(prevPost.getPostId())
				.user(prevPost.getUser())
				.category(category)
				.title(title)
				.description(description)
				.thumbnailUrl(null)
				.price(price)
				.viewCount(prevPost.getViewCount())
				.status("")
				.postPhotoList(prevPost.getPostPhotoList())
				.build();
	}
}

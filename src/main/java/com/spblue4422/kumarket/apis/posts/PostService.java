package com.spblue4422.kumarket.apis.posts;

import com.spblue4422.kumarket.dto.posts.CreatePostRequestDto;
import com.spblue4422.kumarket.dto.posts.PostListItemDto;
import com.spblue4422.kumarket.dto.posts.PostListResponseDto;
import com.spblue4422.kumarket.dto.posts.PostResponseDto;
import com.spblue4422.kumarket.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
	private final PostRepository postRepository;

	@Autowired
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public PostListResponseDto findAllPosts() {
		List<PostListItemDto> itemList = new ArrayList<>();
		List<Post> postDataList = this.postRepository.findAll();

		for(Post postData: postDataList) {
			PostListItemDto postListItem = postData.toPostListItemDto();
			itemList.add(postListItem);
		}

		return PostListResponseDto.builder()
				.postList(itemList)
				.count(itemList.size())
				.build();
	}

	public PostResponseDto findPostByPostId(Long postId) {
		Post postData = this.postRepository.findById(postId).orElseThrow(() -> new RuntimeException());

		return postData.toPostResponseDto();
	}

	public void createPost(CreatePostRequestDto req) {
		return ;
	}
	public void updatePost() {
		return ;
	}
	public void removePost() {
		return ;
	}

}

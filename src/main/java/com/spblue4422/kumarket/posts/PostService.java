package com.spblue4422.kumarket.posts;

import com.spblue4422.kumarket.dto.posts.PostListItemDto;
import com.spblue4422.kumarket.dto.posts.PostListResponseDto;
import com.spblue4422.kumarket.dto.posts.PostResponseDto;
import com.spblue4422.kumarket.users.User;
import com.spblue4422.kumarket.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
	private final UserRepository userRepository;
	private final PostRepository postRepository;

	@Autowired
	public PostService(PostRepository postRepository, UserRepository userRepository) {
		this.postRepository = postRepository;
		this.userRepository = userRepository;
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
		Post postData = this.postRepository.findById(postId).orElse(null);

		return postData.toPostResponseDto();
	}

}

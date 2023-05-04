package com.spblue4422.kumarket.posts;

import com.spblue4422.kumarket.dto.posts.PostListResponseDto;
import com.spblue4422.kumarket.dto.posts.PostResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/posts")
public class PostController {
	private final PostService postService;

	@Autowired
	PostController(PostService postService) {
		this.postService = postService;
	}
	@GetMapping("")
	PostListResponseDto getAllPosts() {

	}

	@GetMapping("/:postId")
	PostResponseDto getPost(@RequestParam("postId") Long postId) {

	}
}

package com.spblue4422.kumarket.posts;

import com.spblue4422.kumarket.dto.BasicResponseDto;
import com.spblue4422.kumarket.dto.posts.PostListResponseDto;
import com.spblue4422.kumarket.dto.posts.PostResponseDto;
import jakarta.persistence.Basic;
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
	public BasicResponseDto getAllPosts() {
		try {
			PostListResponseDto resData = postService.findAllPosts();

			return BasicResponseDto.makeRes(resData, 200, "success");
		} catch(Exception ex) {
			return BasicResponseDto.makeRes(null, 500, ex.getMessage());
		}
	}

	@GetMapping("/:postId")
	public BasicResponseDto getPostByPostId(@RequestParam("postId") Long postId) {
		try{
			PostResponseDto resData = postService.findPostByPostId(postId);

			return BasicResponseDto.makeRes(resData, 200, "success");
		} catch(Exception ex) {
			return BasicResponseDto.makeRes(null, 500, ex.getMessage());
		}
	}
}

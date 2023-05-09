package com.spblue4422.kumarket.apis.posts;

import com.spblue4422.kumarket.dto.BasicResponseDto;
import com.spblue4422.kumarket.dto.posts.CreatePostRequestDto;
import com.spblue4422.kumarket.dto.posts.PostListResponseDto;
import com.spblue4422.kumarket.dto.posts.PostResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/posts")
public class PostController {
	private final PostService postService;

	@Autowired
	public PostController(PostService postService) {
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

	@PostMapping("/add")
	public BasicResponseDto addPost(@RequestBody() CreatePostRequestDto req) {
		try {
			postService.createPost(req);

			return BasicResponseDto.makeRes(null, 200, "success");
		} catch(Exception ex) {
			return BasicResponseDto.makeRes(null, 500, ex.getMessage());
		}
	}

	@PatchMapping("/modfiy")
	public BasicResponseDto modifyPost() {
		try {
			return BasicResponseDto.makeRes(null, 200, "success");
		} catch(Exception ex) {
			return BasicResponseDto.makeRes(null, 500, ex.getMessage());
		}
	}

	@DeleteMapping("/delete/:postId")
	public BasicResponseDto removePost(@RequestParam("postId") Long postId) {
		try {
			return BasicResponseDto.makeRes(null, 200, "success");
		} catch(Exception ex) {
			return BasicResponseDto.makeRes(null, 500, ex.getMessage());
		}
	}
}

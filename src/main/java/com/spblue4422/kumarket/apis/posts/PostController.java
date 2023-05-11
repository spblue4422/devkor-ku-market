package com.spblue4422.kumarket.apis.posts;

import com.spblue4422.kumarket.dto.posts.SavePostRequestDto;
import com.spblue4422.kumarket.dto.posts.PostListResponseDto;
import com.spblue4422.kumarket.dto.posts.PostResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController("/posts")
public class PostController {
	private final PostService postService;

	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllPosts() {
		try {
			PostListResponseDto resData = postService.findAllPosts();

			return ResponseEntity.ok().body(resData);
		} catch(Exception ex) {
			return ResponseEntity.internalServerError().body(ex.getMessage());
		}
	}

	@GetMapping("/{postId}")
	public ResponseEntity<?> getPostByPostId(@RequestParam("postId") Long postId) {
		try{
			PostResponseDto resData = postService.getPostDetail(postId);

			return ResponseEntity.ok().body(resData);
		} catch(Exception ex) {
			return ResponseEntity.internalServerError().body(ex.getMessage());
		}
	}

	@PostMapping("/addPost")
	public ResponseEntity<?> addPost(@RequestPart(value = "postData") SavePostRequestDto req, @RequestPart(value = "images") List<MultipartFile> images) {
		try {
			Long resData = postService.insertPost(req, images, "spblue4422");

			return ResponseEntity.ok().body(resData);
		} catch(Exception ex) {
			return ResponseEntity.internalServerError().body(ex.getMessage());
		}
	}

	@PatchMapping("/modifyPost/{postId}")
	public ResponseEntity<?> modifyPost(@RequestPart(value = "postId") Long postId, @RequestPart(value = "postData") SavePostRequestDto req, @RequestPart(value = "images") List<MultipartFile> images) {
		try {
			Long resData = postService.updatePost(postId, req, images, "spblue4422");

			return ResponseEntity.ok().body(null);
		} catch(Exception ex) {
			return ResponseEntity.internalServerError().body(ex.getMessage());
		}
	}

	@DeleteMapping("/removePost/{postId}")
	public ResponseEntity<?> removePost(@RequestParam("postId") Long postId) {
		try {
			Long resData = postService.deletePost(postId, "spblue4422");

			return ResponseEntity.ok().body(null);
		} catch(Exception ex) {
			return ResponseEntity.internalServerError().body(ex.getMessage());
		}
	}
}

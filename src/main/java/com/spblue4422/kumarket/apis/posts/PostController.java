package com.spblue4422.kumarket.apis.posts;

import com.spblue4422.kumarket.dto.posts.SavePostRequestDto;
import com.spblue4422.kumarket.dto.posts.PostListResponseDto;
import com.spblue4422.kumarket.dto.posts.PostResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController()
@RequestMapping("/posts")
public class PostController {
	private final PostService postService;

	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}

	@GetMapping("/list/all")
	public ResponseEntity<?> getAllPosts(Pageable pageable) {
		try {
			PostListResponseDto resData = postService.getAllPosts(pageable);

			return ResponseEntity.ok().body(resData);
		} catch(Exception ex) {
			return ResponseEntity.internalServerError().body(ex.getMessage());
		}
	}

	@GetMapping("/list/bookmarked")
	public ResponseEntity<?> getAllBookmarkedPosts() {
		try {
			PostListResponseDto resData = postService.getAllBookmarkedPosts("spblue4422");

			return ResponseEntity.ok().body(resData);
		} catch(Exception ex) {
			return ResponseEntity.internalServerError().body(ex.getMessage());
		}
	}

	@GetMapping("/{postId}")
	public ResponseEntity<?> getPostByPostId(@PathVariable("postId") Long postId) {
		try{
			PostResponseDto resData = postService.getPostDetail(postId, "spblue4422");

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
	public ResponseEntity<?> modifyPost(@PathVariable(value = "postId") Long postId, @RequestPart(value = "postData") SavePostRequestDto req, @RequestPart(value = "images") List<MultipartFile> images) {
		try {
			Long resData = postService.updatePost(postId, req, images, "spblue4422");

			return ResponseEntity.ok().body(resData);
		} catch(Exception ex) {
			return ResponseEntity.internalServerError().body(ex.getMessage());
		}
	}

	@DeleteMapping("/removePost/{postId}")
	public ResponseEntity<?> removePost(@PathVariable("postId") Long postId) {
		try {
			Long resData = postService.deletePost(postId, "spblue4422");

			return ResponseEntity.ok().body(resData);
		} catch(Exception ex) {
			return ResponseEntity.internalServerError().body(ex.getMessage());
		}
	}
}

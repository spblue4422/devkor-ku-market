package com.spblue4422.kumarket.apis.bookmarks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/bookmarks")
public class BookmarkController {
	private final BookmarkService bookmarkService;

	@Autowired
	public BookmarkController(BookmarkService bookmarkService) {
		this.bookmarkService = bookmarkService;
	}

	@PostMapping("/addMark")
	public ResponseEntity<?> addBookmark(@RequestBody() Long postId) {
		try {
			return null;
		} catch(Exception ex) {
			return null;
		}
	}

	@DeleteMapping("/removeMark/{postId}")
	public ResponseEntity<?> removeBookmark(@RequestParam("postId") Long postId) {
		try {
			return null;
		} catch(Exception ex) {
			return null;
		}
	}
}

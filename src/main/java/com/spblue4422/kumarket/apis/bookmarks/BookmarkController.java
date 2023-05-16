package com.spblue4422.kumarket.apis.bookmarks;

import com.spblue4422.kumarket.apis.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController()
@RequestMapping("/bookmarks")
public class BookmarkController {
	private final BookmarkService bookmarkService;

	@Autowired
	public BookmarkController(BookmarkService bookmarkService) {
		this.bookmarkService = bookmarkService;
	}

	@PostMapping("/addMark")
	public ResponseEntity<?> addBookmark(@RequestBody Map<String, Long> postIdMap) {
		try {
			Long resData = bookmarkService.insertBookmark(postIdMap.get("postId"), "test1");

			return ResponseEntity.ok().body(resData);
		} catch(Exception ex) {
			return ResponseEntity.internalServerError().body(ex.getMessage());
		}
	}

	@DeleteMapping("/removeMark/{postId}")
	public ResponseEntity<?> removeBookmark(@PathVariable("postId") Long postId) {
		try {
			Long resData = bookmarkService.deleteBookmark(postId, "test1");

			return ResponseEntity.ok().body(resData);
		} catch(Exception ex) {
			return ResponseEntity.internalServerError().body(ex.getMessage());
		}
	}
}

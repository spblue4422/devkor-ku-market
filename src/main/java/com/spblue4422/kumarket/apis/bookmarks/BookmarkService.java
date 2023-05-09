package com.spblue4422.kumarket.apis.bookmarks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookmarkService {
	private final BookmarkRepository bookmarkRepository;

	@Autowired
	public BookmarkService(BookmarkRepository bookmarkRepository) {
		this.bookmarkRepository = bookmarkRepository;
	}

	public void insertBookmark(Long postId, Long userId) {

	}

	public void deleteBookmark(Long postId, Long userId) {

	}
}

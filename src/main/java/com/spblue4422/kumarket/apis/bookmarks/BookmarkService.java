package com.spblue4422.kumarket.apis.bookmarks;

import com.spblue4422.kumarket.apis.posts.PostRepository;
import com.spblue4422.kumarket.apis.posts.PostService;
import com.spblue4422.kumarket.apis.users.UserRepository;
import com.spblue4422.kumarket.apis.users.UserService;
import com.spblue4422.kumarket.entity.Bookmark;
import com.spblue4422.kumarket.entity.Post;
import com.spblue4422.kumarket.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookmarkService {
	private final BookmarkRepository bookmarkRepository;

	private final UserService userService;
	private final PostService postService;

	@Autowired
	public BookmarkService(BookmarkRepository bookmarkRepository, UserService userService, PostService postService) {
		this.bookmarkRepository = bookmarkRepository;
		this.userService = userService;
		this.postService = postService;
	}

	public Long insertBookmark(Long postId, String userName) {
		User userData = userService.findUserByUserName(userName);
		Post postData = postService.findPostByPostId(postId);
		Bookmark bookmarkData = findBookmarkByUserIdAndPostId(userData.getUserId(), postId);

		if(bookmarkData != null) {
			throw new RuntimeException();
		}

		Bookmark newBookmark = Bookmark.builder()
				.user(userData)
				.post(postData)
				.build();

		Bookmark savedBookmark = bookmarkRepository.save(newBookmark);
		userData.addBookmarkToList(savedBookmark);

		return savedBookmark.getBookmarkId();
	}

	public Long deleteBookmark(Long postId, String userName) {
		User userData = userService.findUserByUserName(userName);
		//요거는 살짝 고려해봐야할듯? 게시글이 삭제되면 북마크도 자동삭제?
		Post postData = postService.findPostByPostId(postId);
		Bookmark bookmarkData = findBookmarkByUserIdAndPostId(userData.getUserId(), postId);

		if(bookmarkData == null) {
			throw new RuntimeException();
		}

		userData.removeBookmarkFromList(bookmarkData);
		bookmarkRepository.delete(bookmarkData);

		return bookmarkData.getBookmarkId();
	}

	public Bookmark findBookmarkByUserIdAndPostId(Long userId, Long postId) {
		return bookmarkRepository.findBookmarkByUserIdAndPostId(userId, postId).orElse(null);
	}
}

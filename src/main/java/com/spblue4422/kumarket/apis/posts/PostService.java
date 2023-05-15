package com.spblue4422.kumarket.apis.posts;

import com.spblue4422.kumarket.apis.bookmarks.BookmarkRepository;
import com.spblue4422.kumarket.apis.bookmarks.BookmarkService;
import com.spblue4422.kumarket.apis.posts.photos.PostPhotoService;
import com.spblue4422.kumarket.apis.users.UserService;
import com.spblue4422.kumarket.dto.posts.*;
import com.spblue4422.kumarket.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
	private final PostRepository postRepository;
	private final BookmarkRepository bookmarkRepository;
	private final UserService userService;
	private final PostPhotoService postPhotoService;

	@Autowired
	public PostService(PostRepository postRepository, BookmarkRepository bookmarkRepository, UserService userService, PostPhotoService postPhotoService) {
		this.postRepository = postRepository;
		this.bookmarkRepository = bookmarkRepository;
		this.userService = userService;
		this.postPhotoService = postPhotoService;

	}

	public PostListResponseDto getAllPosts(Pageable pageable) {
		List<PostListItemDto> itemList = new ArrayList<>();
		List<Post> postDataList = this.postRepository.findAllByDeletedAtNullOrderByCreatedAtDesc(pageable);

		for(Post postData: postDataList) {
			PostListItemDto postListItem = postData.toPostListItemDto();
			itemList.add(postListItem);
		}

		return PostListResponseDto.builder()
				.postList(itemList)
				.count(itemList.size())
				.build();
	}

	public PostListResponseDto getAllBookmarkedPosts(String userName) {
		User userData = userService.findUserByUserName(userName);
		List<PostListItemDto> itemList = new ArrayList<>();

		List<Bookmark> bookmarkDataList = userData.getBookmarkList();

		for(Bookmark bookmarkData: bookmarkDataList) {
			Long postId = bookmarkData.getPost().getPostId();

			Post postData = postRepository.findById(postId).orElseThrow(() -> new RuntimeException());
			itemList.add(postData.toPostListItemDto());
			
			//paging을 한다면 어느 걸 기준으로 해야할지도 정해야할듯
		}

		return PostListResponseDto.builder()
				.postList(itemList)
				.count(itemList.size())
				.build();
	}

	public PostResponseDto getPostDetail(Long postId, String userName) {
		User userData = userService.findUserByUserName(userName);
		Post postData = findPostByPostId(postId);
		postData.raiseViewCount();

		Bookmark bookmarkData = bookmarkRepository.findBookmarkByUserIdAndPostId(userData.getUserId(), postId).orElse(null);
		if(bookmarkData != null) {
			return postRepository.save(postData).toPostResponseDto(true);
		} else {
			return postRepository.save(postData).toPostResponseDto(false);
		}
	}

	public Long insertPost(SavePostRequestDto req, List<MultipartFile> photos, String userName) throws IOException {
		User userData = userService.findUserByUserName(userName);
		Post newPost = postRepository.save(req.toInsertPostEntity(userData));

		for(MultipartFile photo: photos) {
			if(photo.isEmpty()) continue;

			PostPhoto photoData = postPhotoService.insertPostPhoto(photo, newPost, photos.indexOf(photo));
			newPost.addPhotoToList(photoData);

			if(photos.indexOf(photo) == 0) {
				newPost.setThumbnailUrl(photoData.getSavedPath());
			}
		}

		return postRepository.save(newPost).getPostId();
	}

	public Long updatePost(Long postId, SavePostRequestDto req, List<MultipartFile> photos, String userName) throws IOException {
		Post postData = findPostByPostId(postId);
		String dataUserName = postData.getUser().getUserName();

		if(!dataUserName.equals(userName)) {
			throw new RuntimeException("본인의 게시물이 아님");
		}

		Post newPost = req.toUpdatePostEntity(postData);

		for (PostPhoto postPhoto: newPost.getPostPhotoList())
		{
			postPhotoService.deletePostPhoto(postPhoto);
		}

		newPost.emptyPhotoList();

		for(MultipartFile photo: photos) {
			if(photo.isEmpty()) continue;

			PostPhoto photoData = postPhotoService.insertPostPhoto(photo, newPost, photos.indexOf(photo));
			newPost.addPhotoToList(photoData);

			if(photos.indexOf(photo) == 0) {
				newPost.setThumbnailUrl(photoData.getSavedPath());
			}
		}

		return postRepository.save(newPost).getPostId();
	}

	public Long deletePost(Long postId, String userName) {
		Post postData = findPostByPostId(postId);
		String dataUserName = postData.getUser().getUserName();

		if(!dataUserName.equals(userName)) {
			throw new RuntimeException("본인의 게시물이 아님");
		}

		postRepository.delete(postData);

		return postId;
	}

	public Post findPostByPostId(Long postId) {
		return postRepository.findByPostIdAndDeletedAtNull(postId).orElseThrow(() -> new RuntimeException());
	}

	public Boolean isPostExistsByPostId(Long postId) {
		//deletedat 구별해줄려나??
		return postRepository.existsById(postId);
	}
}

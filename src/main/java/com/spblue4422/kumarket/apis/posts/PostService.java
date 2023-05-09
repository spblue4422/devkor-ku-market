package com.spblue4422.kumarket.apis.posts;

import com.spblue4422.kumarket.apis.posts.photos.PostPhotoService;
import com.spblue4422.kumarket.apis.users.UserRepository;
import com.spblue4422.kumarket.apis.users.UserService;
import com.spblue4422.kumarket.dto.posts.*;
import com.spblue4422.kumarket.entity.Post;
import com.spblue4422.kumarket.entity.PostPhoto;
import com.spblue4422.kumarket.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
	private final PostRepository postRepository;
	private final UserService userService;
	private final PostPhotoService postPhotoService;

	@Autowired
	public PostService(PostRepository postRepository, UserService userService, PostPhotoService postPhotoService) {
		this.postRepository = postRepository;
		this.userService = userService;
		this.postPhotoService = postPhotoService;
	}

	public PostListResponseDto findAllPosts() {
		List<PostListItemDto> itemList = new ArrayList<>();
		List<Post> postDataList = this.postRepository.findAll();

		for(Post postData: postDataList) {
			PostListItemDto postListItem = postData.toPostListItemDto();
			itemList.add(postListItem);
		}

		return PostListResponseDto.builder()
				.postList(itemList)
				.count(itemList.size())
				.build();
	}

	public PostResponseDto getPostDetail(Long postId) {
		Post postData = this.findPostByPostId(postId);
		postData.raiseViewCount();

		return postRepository.save(postData).toPostResponseDto();
	}

	public Long insertPost(SavePostRequestDto req, List<MultipartFile> photos, String userName) throws IOException {
		User userData = userService.findUserByUserName(userName);
		Post postData = postRepository.save(req.toInsertPostEntity(userData));

		for(MultipartFile photo: photos) {
			PostPhoto photoData = postPhotoService.insertPostPhoto(photo, postData, photos.indexOf(photo) + 1);
			postData.addPhotoToList(photoData);

			if(photos.indexOf(photo) == 0) {
				postData.setThumbnailUrl(photoData.getSavedPath());
			}
		}

		return postRepository.save(postData).getPostId();
	}

	public void updatePost(Long postId, SavePostRequestDto req, List<MultipartFile> photos, String userName) throws IOException {
		User userData = userService.findUserByUserName(userName);
		Post postData = findPostByPostId(postId);

		for(MultipartFile photo: photos) {

		}

		return ;
	}

	public void deletePost(Long postId, String userName) {
		User userData = userService.findUserByUserName(userName);
		return ;
	}

	public Post findPostByPostId(Long postId) {
		return this.postRepository.findById(postId).orElseThrow(() -> new RuntimeException());
	}
}

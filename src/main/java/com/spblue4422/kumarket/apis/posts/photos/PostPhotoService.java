package com.spblue4422.kumarket.apis.posts.photos;

import com.spblue4422.kumarket.apis.common.ImageService;
import com.spblue4422.kumarket.dto.common.ImageInfoDto;
import com.spblue4422.kumarket.entity.Post;
import com.spblue4422.kumarket.entity.PostPhoto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PostPhotoService {
	private final PostPhotoRepository postPhotoRepository;
	private final ImageService imageService;

	public PostPhotoService(PostPhotoRepository postPhotoService, ImageService imageService) {
		this.postPhotoRepository = postPhotoService;
		this.imageService = imageService;
	}

	public PostPhoto insertPostPhoto(MultipartFile photo, Post postData, Integer order) throws IOException {
		ImageInfoDto savedImage = imageService.saveFile(photo, "");
		PostPhoto photoData = PostPhoto
				.builder()
				.savedName(savedImage.getSavedName())
				.originalName(savedImage.getOriginalName())
				.savedPath(savedImage.getSavedPath())
				.order(order)
				.post(postData)
				.build();

		return this.postPhotoRepository.save(photoData);
	}

	public void deletePostPhoto(PostPhoto photo) {
		this.postPhotoRepository.deleteById(photo.getPostPhotoId());
	}
}

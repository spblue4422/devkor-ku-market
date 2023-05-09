package com.spblue4422.kumarket.apis.common;

import com.spblue4422.kumarket.dto.common.ImageInfoDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class ImageService {
	public ImageInfoDto saveFile(MultipartFile photo, String dir) throws IOException {
		if(photo.isEmpty()) return null;

		String originalName = photo.getOriginalFilename();
		String savedName = UUID.randomUUID() + originalName.substring(originalName.lastIndexOf("."));
		String savedPath = dir + savedName;

		photo.transferTo(new File(savedPath));

		return ImageInfoDto.builder()
						   .originalName(originalName)
						   .savedName(savedName)
						   .savedPath(savedPath)
						   .build();
	}

	public void deleteFile(String savedUrl) {
//		Boolean isDeleted =
	}
}

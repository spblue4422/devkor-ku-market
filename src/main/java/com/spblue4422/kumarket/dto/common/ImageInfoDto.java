package com.spblue4422.kumarket.dto.common;

import lombok.*;

@Getter
@Builder
public class ImageInfoDto {
	private String originalName;
	private String savedName;
	private String savedPath;
}


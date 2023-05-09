package com.spblue4422.kumarket.dto.users;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileResponseDto {
	private Long userId;
	private String userName;
	private Integer likes;
}

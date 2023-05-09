package com.spblue4422.kumarket.dto.users;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class MyProfileResponseDto extends UserProfileResponseDto {
	private String phoneNum;
}

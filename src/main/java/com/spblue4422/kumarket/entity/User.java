package com.spblue4422.kumarket.entity;

import com.spblue4422.kumarket.dto.users.MyProfileResponseDto;
import com.spblue4422.kumarket.dto.users.UserProfileResponseDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;

@Getter
@Builder
//@SuperBuilder
@SQLDelete(sql = "UPDATE tb_user SET deletedAt = now() where userId = ? and deletedAt is null")
@Entity(name="TB_User")
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private Long userId;

	@Column(name = "userName")
	@NotNull()
	private String userName;

	@Column(name = "password")
	@NotNull()
	private String password;

	@Column(name="phoneNum")
	@NotNull()
	private String phoneNum;

	@Column(name="likes")
	@NotNull()
	private Integer likes;

	public UserProfileResponseDto toUserProfileResponseDto() {
		return UserProfileResponseDto
				.builder()
				.userId(userId)
				.userName(userName)
				.likes(likes)
				.build();
	}

	public MyProfileResponseDto toMyProfileResponseDto() {
		return MyProfileResponseDto
				.builder()
				.userId(userId)
				.userName(userName)
				.phoneNum(phoneNum)
				.likes(likes)
				.build();
	}
}

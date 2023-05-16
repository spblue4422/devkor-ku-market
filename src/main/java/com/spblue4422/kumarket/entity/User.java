package com.spblue4422.kumarket.entity;

import com.spblue4422.kumarket.dto.users.MyProfileResponseDto;
import com.spblue4422.kumarket.dto.users.UserProfileResponseDto;
import com.spblue4422.kumarket.entity.common.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;

import java.util.List;

@Getter
@SuperBuilder
@SQLDelete(sql = "UPDATE tb_user SET deletedAt = now() where userId = ? and deletedAt is null")
@Entity(name="TB_User")
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {
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

	@OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Bookmark> bookmarkList;

	public void addBookmarkToList(Bookmark bookmark) {
		this.bookmarkList.add(bookmark);
	}

	public void removeBookmarkFromList(Bookmark bookmark) {
		this.bookmarkList.remove(bookmark);
	}

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

package com.spblue4422.kumarket.users;

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

}

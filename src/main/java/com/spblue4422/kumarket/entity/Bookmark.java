package com.spblue4422.kumarket.entity;

import com.spblue4422.kumarket.entity.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;

@Getter
@SuperBuilder
@SQLDelete(sql = "UPDATE tb_bookmark SET deletedAt = now() where bookmarkId = ? and deletedAt is null")
@Entity(name="TB_Bookmark")
@AllArgsConstructor
@NoArgsConstructor
public class Bookmark extends BaseEntity {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bookmarkId")
	private Long bookmarkId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="bookmark_user")
	private User user;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bookmark_post")
	private Post post;
}

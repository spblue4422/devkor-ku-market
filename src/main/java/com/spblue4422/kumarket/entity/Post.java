package com.spblue4422.kumarket.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.spblue4422.kumarket.dto.posts.PostListItemDto;
import com.spblue4422.kumarket.dto.posts.PostResponseDto;
import com.spblue4422.kumarket.entity.common.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;

import java.util.List;

@Getter
@SuperBuilder
@SQLDelete(sql = "UPDATE tb_post SET deletedAt = now() where postId = ? and deletedAt is null")
@Entity(name="TB_Post")
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Post extends BaseEntity {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "postId")
	private Long postId;

	@ManyToOne()
	@JoinColumn(name="post_user")
	private User user;
	//enum
	@Column(name="category")
	@NotNull()
	private String category;

	@Column(name="title")
	@NotNull()
	private String title;

	@Column(name = "description")
	@NotNull()
	private String description;

	@Column(name="thumbnailUrl")
	private String thumbnailUrl;

	@Column(name = "price")
	@NotNull()
	private Integer price;

	@Column(name = "viewCount")
	@NotNull()
	private Integer viewCount;

	//enum
	@Column(name = "status")
	private String status;

	@OneToMany(mappedBy = "post", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<PostPhoto> postPhotoList;

	public void setThumbnailUrl(String url) {
		this.thumbnailUrl = url;
	}

	public void raiseViewCount() {
		this.viewCount = viewCount + 1;
	}

	public void addPhotoToList(PostPhoto photo) {
		this.postPhotoList.add(photo);
	}

	public void emptyPhotoList() {
//		this.thumbnailUrl = null;
		this.postPhotoList.clear();
	}

	public PostResponseDto toPostResponseDto(Boolean isBookmarked) {
		return PostResponseDto
				.builder()
				.postId(postId)
				.category(category)
				.title(title)
				.thumbnailUrl(thumbnailUrl)
				.price(price)
				.viewCount(viewCount)
				.postPhotoList(postPhotoList)
				.userId(user.getUserId())
				.userName(user.getUserName())
				.likes(user.getLikes())
				.isBookmarked(isBookmarked)
				.build();
	}

	public PostListItemDto toPostListItemDto() {
		return PostListItemDto
				.builder()
				.postId(postId)
				.category(category)
				.title(title)
				.thumbnailUrl(thumbnailUrl)
				.build();
	}
}

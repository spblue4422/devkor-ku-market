package com.spblue4422.kumarket.entity;

import com.spblue4422.kumarket.entity.Post;
import com.spblue4422.kumarket.entity.common.Image;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@Entity(name="TB_PostPhoto")
@AllArgsConstructor
@NoArgsConstructor
public class PostPhoto extends Image {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "photoId")
	private Long photoId;

	@Column(name = "order")
	private Integer order;

	@ManyToOne()
	@JoinColumn(name="photo_post")
	private Post post;
}

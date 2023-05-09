package com.spblue4422.kumarket.entity;

import com.spblue4422.kumarket.entity.Post;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@Entity(name="TB_PostPhoto")
@AllArgsConstructor
@NoArgsConstructor
public class PostPhoto {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "photoId")
	private Long photoId;

	@ManyToOne()
	@JoinColumn(name="photo_post")
	private Post post;

}

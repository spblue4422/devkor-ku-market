package com.spblue4422.kumarket.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.spblue4422.kumarket.entity.Post;
import com.spblue4422.kumarket.entity.common.Image;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;

@Getter
@SuperBuilder
@Entity(name="TB_PostPhoto")
@SQLDelete(sql = "UPDATE tb_postphoto SET deletedAt = now() where postPhotoId = ? and deletedAt is null")
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class PostPhoto extends Image {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "photoId")
	private Long postPhotoId;

	@Column(name = "order")
	private Integer order;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="photo_post")
	private Post post;
}

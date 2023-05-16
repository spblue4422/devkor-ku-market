package com.spblue4422.kumarket.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.spblue4422.kumarket.entity.common.Image;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;

@Getter
@SuperBuilder
@SQLDelete(sql = "UPDATE tb_postphoto SET deletedAt = now() where postPhotoId = ? and deletedAt is null")
@Entity(name="TB_PostPhoto")
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class PostPhoto extends Image {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "postPhotoId")
	private Long postPhotoId;

	@Column(name = "photoOrder")
	private Integer photoOrder;

	@ManyToOne()
	@JoinColumn(name="postPhoto_post")
	private Post post;
}

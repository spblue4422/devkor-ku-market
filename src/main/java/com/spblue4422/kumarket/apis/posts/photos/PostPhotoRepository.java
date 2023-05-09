package com.spblue4422.kumarket.apis.posts.photos;

import com.spblue4422.kumarket.entity.PostPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostPhotoRepository extends JpaRepository<PostPhoto, Long> {
}

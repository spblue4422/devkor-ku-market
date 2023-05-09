package com.spblue4422.kumarket.apis.posts;

import com.spblue4422.kumarket.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}

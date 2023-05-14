package com.spblue4422.kumarket.apis.posts;

import com.spblue4422.kumarket.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	@Query(value = "select p from TB_Post p left join TB_Bookmark b on p.postId = b.post.postId where b.user.userId = :userId")
	List<Post> findAllPostsWithBookmarked(Long userId);

	List<Post> findAllByDeletedAtIsNull();
	Optional<Post> findByPostIdAndDeletedAtIsNull(Long postId);
}

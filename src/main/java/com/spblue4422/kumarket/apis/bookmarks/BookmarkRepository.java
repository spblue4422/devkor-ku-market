package com.spblue4422.kumarket.apis.bookmarks;

import com.spblue4422.kumarket.entity.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
	@Query(value =
			"select b, u, p from TB_Bookmark b left join TB_User u on b.user.userId = u.userId left join TB_Post p on b.post.postId = p.postId where b.user.userId = :userId and b.post.postId = :postId and b.deletedAt is not null")
	Optional<Bookmark> findBookmarkByUserIdAndPostId(Long userId, Long postId);
}

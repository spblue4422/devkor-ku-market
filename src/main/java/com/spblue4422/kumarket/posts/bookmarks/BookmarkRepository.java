package com.spblue4422.kumarket.posts.bookmarks;

import com.spblue4422.kumarket.entity.BookMark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkRepository extends JpaRepository<BookMark, Long> {
}

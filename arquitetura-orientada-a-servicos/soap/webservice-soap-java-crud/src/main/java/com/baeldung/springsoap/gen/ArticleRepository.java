package com.baeldung.springsoap.gen;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

	Article findByArticleId(long articleId);

	List<Article> findByTitleAndCategory(String title, String category);
}

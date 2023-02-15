package com.craftdemo.contentauthoringtool.repository;

import com.craftdemo.contentauthoringtool.model.HelpArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HelpArticleRepository extends JpaRepository<HelpArticle, Integer> {
    <T> List<T> findByUserId(UUID userId, Class<T> type);

}

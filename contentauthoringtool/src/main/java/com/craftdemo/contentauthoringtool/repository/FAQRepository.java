package com.craftdemo.contentauthoringtool.repository;

import com.craftdemo.contentauthoringtool.model.FAQ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FAQRepository extends JpaRepository<FAQ, Integer> {
    <T> List<T> findByUserId(UUID userId, Class<T> type);

}

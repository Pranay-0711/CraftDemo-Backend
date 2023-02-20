package com.craftdemo.contentauthoringtool.repository;

import com.craftdemo.contentauthoringtool.model.FormPayload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SchemaRepository extends JpaRepository<FormPayload, Integer> {
    <T> T findByType(String formType, Class<T> type);
}

package com.Emazon.EmazonStockMicroservice.infrastructure.output.jpa.repository;

import com.Emazon.EmazonStockMicroservice.infrastructure.output.jpa.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
    boolean existsByName(String name);
}

package com.Emazon.EmazonStockMicroservice.infrastructure.output.jpa.adapter;

import com.Emazon.EmazonStockMicroservice.domain.model.Category;
import com.Emazon.EmazonStockMicroservice.domain.spi.ICategoryPersistencePort;
import com.Emazon.EmazonStockMicroservice.infrastructure.exception.CategoryAlreadyExistsException;
import com.Emazon.EmazonStockMicroservice.infrastructure.output.jpa.mapper.CategoryEntityMapper;
import com.Emazon.EmazonStockMicroservice.infrastructure.output.jpa.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryJpaAdapter implements ICategoryPersistencePort {
    private final ICategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Override
    public void createCategory(Category category) {
        if (categoryRepository.existsByName(category.getName())) {
            throw new CategoryAlreadyExistsException();
        }
        categoryRepository.save(categoryEntityMapper.toCategoryEntity(category));
    }
}

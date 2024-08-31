package com.Emazon.EmazonStockMicroservice.infrastructure.output.jpa.adapter;

import com.Emazon.EmazonStockMicroservice.domain.model.Category;
import com.Emazon.EmazonStockMicroservice.infrastructure.exception.CategoryAlreadyExistsException;
import com.Emazon.EmazonStockMicroservice.infrastructure.output.jpa.entity.CategoryEntity;
import com.Emazon.EmazonStockMicroservice.infrastructure.output.jpa.mapper.CategoryEntityMapper;
import com.Emazon.EmazonStockMicroservice.infrastructure.output.jpa.repository.ICategoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryJpaAdapterTest {

    @Mock
    private ICategoryRepository categoryRepository;

    @Mock
    private CategoryEntityMapper categoryEntityMapper;

    @InjectMocks
    private CategoryJpaAdapter categoryJpaAdapter;

    @Test
    @DisplayName("Should throw CategoryAlreadyExists when name is occupied.")
    void createCategory_ShouldThrowException_WhenCategoryAlreadyExists() {
        Category category = new Category();
        category.setName("Foods");

        when(categoryRepository.existsByName("Foods")).thenReturn(true);

        assertThrows(CategoryAlreadyExistsException.class, () -> categoryJpaAdapter.createCategory(category));
    }

    @Test
    @DisplayName("Should successfully create a category when name is not occupied.")
    void createCategory_WhenCategoryDoesNotExists() {
        Category category = new Category();
        category.setName("Foods");

        CategoryEntity categoryEntity =  new CategoryEntity();

        when(categoryEntityMapper.toCategoryEntity(category)).thenReturn(categoryEntity);
        when(categoryRepository.existsByName("Foods")).thenReturn(false);

        categoryJpaAdapter.createCategory(category);

        verify(categoryRepository).save(categoryEntity);
    }
}
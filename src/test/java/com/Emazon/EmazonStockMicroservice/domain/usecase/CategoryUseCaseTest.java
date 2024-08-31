package com.Emazon.EmazonStockMicroservice.domain.usecase;

import com.Emazon.EmazonStockMicroservice.domain.exception.category.CategoryDescriptionTooLongException;
import com.Emazon.EmazonStockMicroservice.domain.exception.category.CategoryEmptyDescriptionException;
import com.Emazon.EmazonStockMicroservice.domain.exception.category.CategoryEmptyNameException;
import com.Emazon.EmazonStockMicroservice.domain.exception.category.CategoryNameTooLongException;
import com.Emazon.EmazonStockMicroservice.domain.model.Category;
import com.Emazon.EmazonStockMicroservice.domain.spi.ICategoryPersistencePort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CategoryUseCaseTest {

    @Mock
    private ICategoryPersistencePort categoryPersistencePort;

    @InjectMocks
    private CategoryUseCase categoryUseCase;

    @Test
    @DisplayName("Should successfully create a category when valid data is provided.")
    void createCategory_ValidCategory () {
        Category category = new Category();

        category.setName("This name is valid");
        category.setDescription("This description is valid");

        categoryUseCase.createCategory(category);

        verify(categoryPersistencePort).createCategory(category);
    }

    @Test
    @DisplayName("Should throw CategoryEmptyNameException when name is empty.")
    void createCategory_ShouldThrowException_WhenNameIsEmpty () {
        Category category = new Category();

        category.setName("");
        category.setDescription("This description is valid");

        assertThrows(CategoryEmptyNameException.class, () -> {
            categoryUseCase.createCategory(category);
        });

        verify(categoryPersistencePort, never()).createCategory(any(Category.class));
    }

    @Test
    @DisplayName("Should throw CategoryEmptyDescriptionException when description is empty.")
    void createCategory_ShouldThrowException_WhenDescriptionIsEmpty () {
        Category category = new Category();

        category.setName("This name is valid");
        category.setDescription("");

        assertThrows(CategoryEmptyDescriptionException.class, () -> {
            categoryUseCase.createCategory(category);
        });

        verify(categoryPersistencePort, never()).createCategory(any(Category.class));
    }

    @Test
    @DisplayName("Should throw CategoryNameTooLongException when name exceeds the limit.")
    void createCategory_ShouldThrowException_WhenNameIsTooLong () {
        Category category = new Category();

        category.setName("This name is longer than 50 characters, " +
                "which is invalid for create a category successfully");
        category.setDescription("This description is valid");

        assertThrows(CategoryNameTooLongException.class, () -> {
            categoryUseCase.createCategory(category);
        });

        verify(categoryPersistencePort, never()).createCategory(any(Category.class));
    }

    @Test
    @DisplayName("Should throw CategoryDescriptionTooLongException when description exceeds the limit.")
    void createCategory_ShouldThrowException_WhenDescriptionIsTooLong () {
        Category category = new Category();

        category.setName("This name is valid");
        category.setDescription("This description is longer than 90 characters, " +
                "which is invalid for create a category successfully");

        assertThrows(CategoryDescriptionTooLongException.class, () -> {
            categoryUseCase.createCategory(category);
        });

        verify(categoryPersistencePort, never()).createCategory(any(Category.class));
    }
}
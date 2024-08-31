package com.Emazon.EmazonStockMicroservice.domain.usecase;

import com.Emazon.EmazonStockMicroservice.domain.api.ICategoryServicePort;
import com.Emazon.EmazonStockMicroservice.domain.exception.category.CategoryDescriptionTooLongException;
import com.Emazon.EmazonStockMicroservice.domain.exception.category.CategoryEmptyDescriptionException;
import com.Emazon.EmazonStockMicroservice.domain.exception.category.CategoryEmptyNameException;
import com.Emazon.EmazonStockMicroservice.domain.exception.category.CategoryNameTooLongException;
import com.Emazon.EmazonStockMicroservice.domain.model.Category;
import com.Emazon.EmazonStockMicroservice.domain.spi.ICategoryPersistencePort;
import com.Emazon.EmazonStockMicroservice.domain.util.CommonValidator;

public class CategoryUseCase implements ICategoryServicePort {
    private final ICategoryPersistencePort iCategoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort iCategoryPersistencePort) {
        this.iCategoryPersistencePort = iCategoryPersistencePort;
    }

    @Override
    public void createCategory(Category category) {
        if (CommonValidator.validateStringNotEmpty(category.getName())){
            throw new CategoryEmptyNameException();
        }
        if (CommonValidator.validateStringLength(category.getName(), 50)){
            throw new CategoryNameTooLongException();
        }
        if (CommonValidator.validateStringNotEmpty(category.getDescription())){
            throw new CategoryEmptyDescriptionException();
        }
        if (CommonValidator.validateStringLength(category.getDescription(), 90)){
            throw new CategoryDescriptionTooLongException();
        }

        iCategoryPersistencePort.createCategory(category);
    }
}

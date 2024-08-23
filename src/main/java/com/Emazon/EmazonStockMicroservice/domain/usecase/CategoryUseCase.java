package com.Emazon.EmazonStockMicroservice.domain.usecase;

import com.Emazon.EmazonStockMicroservice.domain.api.ICategoryServicePort;
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
        CommonValidator.validateStringNotEmpty(category.getName(), "name");
        CommonValidator.validateStringLength(category.getName(), 50, "name");
        CommonValidator.validateStringNotEmpty(category.getDescription(), "description");
        CommonValidator.validateStringLength(category.getDescription(), 90, "description");
        iCategoryPersistencePort.createCategory(category);
    }
}

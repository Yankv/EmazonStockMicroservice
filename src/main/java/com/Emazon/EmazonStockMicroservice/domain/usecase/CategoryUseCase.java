package com.Emazon.EmazonStockMicroservice.domain.usecase;

import com.Emazon.EmazonStockMicroservice.domain.api.ICategoryServicePort;
import com.Emazon.EmazonStockMicroservice.domain.model.Category;
import com.Emazon.EmazonStockMicroservice.domain.spi.ICategoryPersistencePort;

public class CategoryUseCase implements ICategoryServicePort {
    private final ICategoryPersistencePort iCategoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort iCategoryPersistencePort) {
        this.iCategoryPersistencePort = iCategoryPersistencePort;
    }

    @Override
    public void createCategory(Category category) {
        iCategoryPersistencePort.createCategory(category);
    }
}

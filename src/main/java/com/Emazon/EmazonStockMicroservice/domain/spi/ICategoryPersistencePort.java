package com.Emazon.EmazonStockMicroservice.domain.spi;

import com.Emazon.EmazonStockMicroservice.domain.model.Category;

public interface ICategoryPersistencePort {
    void createCategory(Category category);
}

package com.Emazon.EmazonStockMicroservice.domain.api;

import com.Emazon.EmazonStockMicroservice.domain.model.Category;

public interface ICategoryServicePort {
    void createCategory(Category category);
}

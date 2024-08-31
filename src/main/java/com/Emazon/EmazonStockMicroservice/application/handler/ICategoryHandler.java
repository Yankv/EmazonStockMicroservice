package com.Emazon.EmazonStockMicroservice.application.handler;

import com.Emazon.EmazonStockMicroservice.application.dto.request.CategoryRequest;

public interface ICategoryHandler {
    void createCategory(CategoryRequest categoryRequest);
}

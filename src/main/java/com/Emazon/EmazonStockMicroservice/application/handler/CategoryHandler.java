package com.Emazon.EmazonStockMicroservice.application.handler;

import com.Emazon.EmazonStockMicroservice.application.dto.request.CategoryRequest;
import com.Emazon.EmazonStockMicroservice.application.mapper.CategoryRequestMapper;
import com.Emazon.EmazonStockMicroservice.application.mapper.CategoryResponseMapper;
import com.Emazon.EmazonStockMicroservice.domain.api.ICategoryServicePort;
import com.Emazon.EmazonStockMicroservice.domain.model.Category;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryHandler implements ICategoryHandler{
    private final ICategoryServicePort iCategoryServicePort;
    private final CategoryRequestMapper categoryRequestMapper;
    private final CategoryResponseMapper categoryResponseMapper;

    @Override
    public void createCategory(CategoryRequest categoryRequest) {
        Category category = categoryRequestMapper.toCategory(categoryRequest);
        iCategoryServicePort.createCategory(category);
    }
}

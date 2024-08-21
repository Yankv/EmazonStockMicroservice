package com.Emazon.EmazonStockMicroservice.application.mapper;

import com.Emazon.EmazonStockMicroservice.application.dto.request.CategoryRequest;
import com.Emazon.EmazonStockMicroservice.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryRequestMapper {
    Category toCategory(CategoryRequest categoryRequest);
}
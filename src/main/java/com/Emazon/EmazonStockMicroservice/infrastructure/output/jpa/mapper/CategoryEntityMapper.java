package com.Emazon.EmazonStockMicroservice.infrastructure.output.jpa.mapper;

import com.Emazon.EmazonStockMicroservice.domain.model.Category;
import com.Emazon.EmazonStockMicroservice.infrastructure.output.jpa.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryEntityMapper {
    CategoryEntity toCategoryEntity(Category category);

    Category toCategory(CategoryEntity categoryEntity);
}

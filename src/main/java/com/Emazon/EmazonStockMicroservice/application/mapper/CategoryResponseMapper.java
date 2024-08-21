package com.Emazon.EmazonStockMicroservice.application.mapper;

import com.Emazon.EmazonStockMicroservice.application.dto.response.CategoryResponse;
import com.Emazon.EmazonStockMicroservice.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryResponseMapper {
    CategoryResponse toCategoryResponse(Category category);

    default List<CategoryResponse> toResponseList(List<Category> categoryList){
        return categoryList.stream()
                .map(category -> {
                    CategoryResponse categoryResponse = new CategoryResponse();
                    categoryResponse.setName(category.getName());
                    categoryResponse.setDescription(category.getDescription());
                    return categoryResponse;
                }).toList();
    }
}

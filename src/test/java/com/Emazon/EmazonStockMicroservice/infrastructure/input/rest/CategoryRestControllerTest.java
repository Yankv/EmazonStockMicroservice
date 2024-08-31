package com.Emazon.EmazonStockMicroservice.infrastructure.input.rest;

import com.Emazon.EmazonStockMicroservice.application.dto.request.CategoryRequest;
import com.Emazon.EmazonStockMicroservice.application.handler.ICategoryHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryRestControllerTest {

    @Mock
    private ICategoryHandler categoryHandler;

    @InjectMocks
    private CategoryRestController categoryRestController;

    @Test
    @DisplayName("Test to create a category.")
    void createCategory_ShouldReturnCreatedStatus() {
        CategoryRequest request = CategoryRequest.builder()
                .name("Technology")
                .description("Technology description")
                .build();

        ResponseEntity<Void> result = categoryRestController.createCategory(request);

        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertNull(result.getBody());
        verify(categoryHandler, times(1)).createCategory(request);
    }
}
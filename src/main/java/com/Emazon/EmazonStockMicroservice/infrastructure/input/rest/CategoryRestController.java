package com.Emazon.EmazonStockMicroservice.infrastructure.input.rest;

import com.Emazon.EmazonStockMicroservice.application.dto.request.CategoryRequest;
import com.Emazon.EmazonStockMicroservice.application.handler.ICategoryHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
@Tag(name = "Category", description = """
        Controller responsible for managing categories within the system.
        This includes operations such as creating and retrieving category information.
        """)
public class CategoryRestController {
    private final ICategoryHandler categoryHandler;

    @Operation(summary = "Create a new category", description = """
            This endpoint allows administrators to add a new category int the system.
            The request body must contain the name and the description of the category.
            It validates that the category name is not registered in the system
            and that the name and description comply with the size restrictions:
            - The name cannot be longer than 50 characters
            - The description cannot be longer than 90 characters
            """    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Category created", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid input. One or more fields are incorrect", content = @Content),
            @ApiResponse(responseCode = "409", description = "Category already exists", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Void> createCategory(@Valid @RequestBody CategoryRequest categoryRequest){
        categoryHandler.createCategory(categoryRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

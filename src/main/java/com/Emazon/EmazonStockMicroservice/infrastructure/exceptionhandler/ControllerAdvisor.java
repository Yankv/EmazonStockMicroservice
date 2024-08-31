package com.Emazon.EmazonStockMicroservice.infrastructure.exceptionhandler;

import com.Emazon.EmazonStockMicroservice.domain.exception.category.CategoryDescriptionTooLongException;
import com.Emazon.EmazonStockMicroservice.domain.exception.category.CategoryEmptyDescriptionException;
import com.Emazon.EmazonStockMicroservice.domain.exception.category.CategoryEmptyNameException;
import com.Emazon.EmazonStockMicroservice.domain.exception.category.CategoryNameTooLongException;
import com.Emazon.EmazonStockMicroservice.infrastructure.util.Constants;
import com.Emazon.EmazonStockMicroservice.infrastructure.exception.CategoryAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RequiredArgsConstructor
public class ControllerAdvisor {

    @ExceptionHandler(CategoryAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleCategoryAlreadyExistsException(CategoryAlreadyExistsException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionResponse(
                String.format(Constants.CATEGORY_ALREADY_EXISTS_EXCEPTION_MESSAGE, exception.getMessage()),
                HttpStatus.CONFLICT.toString(), LocalDateTime.now()
        ));
    }

    @ExceptionHandler(CategoryEmptyNameException.class)
    public ResponseEntity<ExceptionResponse> handleCategoryEmptyNameException(CategoryEmptyNameException exception){
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                String.format(Constants.EMPTY_NAME_EXCEPTION_MESSAGE, exception.getMessage()),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()
        ));
    }

    @ExceptionHandler(CategoryEmptyDescriptionException.class)
    public ResponseEntity<ExceptionResponse> handleCategoryEmptyDescriptionException(CategoryEmptyDescriptionException exception){
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                String.format(Constants.EMPTY_DESCRIPTION_EXCEPTION_MESSAGE, exception.getMessage()),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()
        ));
    }

    @ExceptionHandler(CategoryNameTooLongException.class)
    public ResponseEntity<ExceptionResponse> handleCategoryNameTooLongException(CategoryNameTooLongException exception){
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                String.format(Constants.CATEGORY_NAME_TOO_LONG_EXCEPTION_MESSAGE, exception.getMessage()),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()
        ));
    }

    @ExceptionHandler(CategoryDescriptionTooLongException.class)
    public ResponseEntity<ExceptionResponse> handleCategoryDescriptionTooLongException(CategoryDescriptionTooLongException exception){
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                String.format(Constants.CATEGORY_DESCRIPTION_TOO_LONG_EXCEPTION_MESSAGE, exception.getMessage()),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()
        ));
    }
}

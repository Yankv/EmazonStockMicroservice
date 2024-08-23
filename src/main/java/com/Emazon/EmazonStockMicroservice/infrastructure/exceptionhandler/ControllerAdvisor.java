package com.Emazon.EmazonStockMicroservice.infrastructure.exceptionhandler;

import com.Emazon.EmazonStockMicroservice.domain.exception.EmptyFieldException;
import com.Emazon.EmazonStockMicroservice.domain.exception.InvalidCharacterLengthException;
import com.Emazon.EmazonStockMicroservice.infrastructure.Constants;
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
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                String.format(Constants.CATEGORY_ALREADY_EXISTS_EXCEPTION_MESSAGE, exception.getMessage()),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()
        ));
    }

    @ExceptionHandler(EmptyFieldException.class)
    public ResponseEntity<ExceptionResponse> handleEmptyFieldException(EmptyFieldException exception){
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()
        ));
    }

    @ExceptionHandler(InvalidCharacterLengthException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidCharacterLengthException(EmptyFieldException exception){
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()
        ));
    }
}

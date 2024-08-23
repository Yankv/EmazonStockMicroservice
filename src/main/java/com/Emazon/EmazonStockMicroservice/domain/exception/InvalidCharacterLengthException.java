package com.Emazon.EmazonStockMicroservice.domain.exception;

public class InvalidCharacterLengthException extends RuntimeException{
    public InvalidCharacterLengthException(String message){
        super(message);
    }
}

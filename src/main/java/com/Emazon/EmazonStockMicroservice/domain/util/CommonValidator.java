package com.Emazon.EmazonStockMicroservice.domain.util;

import com.Emazon.EmazonStockMicroservice.domain.exception.EmptyFieldException;

public class CommonValidator {
    private CommonValidator () {
        throw new IllegalStateException("utility class");
    }

    public static void validateStringNotEmpty(String value, String fieldName){
        if (value.trim().isEmpty()) {
            throw new EmptyFieldException("Field '" + fieldName + "' cannot be null");
        }
    }

    public static void validateStringLength(String value, int maxLength, String fieldName){
        if (value.length() > maxLength){
            throw new EmptyFieldException("Field '" + fieldName + "' cannot have more than "
                    + maxLength + " characters");
        }
    }
}

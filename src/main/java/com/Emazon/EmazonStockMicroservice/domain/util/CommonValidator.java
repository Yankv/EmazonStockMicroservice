package com.Emazon.EmazonStockMicroservice.domain.util;

public class CommonValidator {
    private CommonValidator () {
        throw new IllegalStateException("utility class");
    }

    public static boolean validateStringNotEmpty(String value){
        return value.trim().isEmpty();
    }

    public static boolean validateStringLength(String value, int maxLength){
        return value.length() > maxLength;
    }
}

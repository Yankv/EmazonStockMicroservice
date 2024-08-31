package com.Emazon.EmazonStockMicroservice.infrastructure.util;

public class Constants {
    private Constants(){
        throw new IllegalStateException("utility class");
    }

    public static final String CATEGORY_ALREADY_EXISTS_EXCEPTION_MESSAGE = "The category you want to create already exists";
    public static final String EMPTY_NAME_EXCEPTION_MESSAGE = "Field 'name' cannot be null";
    public static final String EMPTY_DESCRIPTION_EXCEPTION_MESSAGE = "Field 'description' cannot be null";
    public static final String CATEGORY_NAME_TOO_LONG_EXCEPTION_MESSAGE = "Field 'name' cannot have more than 50 characters";
    public static final String CATEGORY_DESCRIPTION_TOO_LONG_EXCEPTION_MESSAGE = "Field 'description' cannot have more than 90 characters";
}

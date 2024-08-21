package com.Emazon.EmazonStockMicroservice.infrastructure.configuration;

import com.Emazon.EmazonStockMicroservice.domain.api.ICategoryServicePort;
import com.Emazon.EmazonStockMicroservice.domain.spi.ICategoryPersistencePort;
import com.Emazon.EmazonStockMicroservice.domain.usecase.CategoryUseCase;
import com.Emazon.EmazonStockMicroservice.infrastructure.output.jpa.adapter.CategoryJpaAdapter;
import com.Emazon.EmazonStockMicroservice.infrastructure.output.jpa.mapper.CategoryEntityMapper;
import com.Emazon.EmazonStockMicroservice.infrastructure.output.jpa.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final ICategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Bean
    public ICategoryPersistencePort categoryPersistencePort(){
        return new CategoryJpaAdapter(categoryRepository, categoryEntityMapper);
    }

    @Bean
    public ICategoryServicePort categoryServicePort(){
        return new CategoryUseCase(categoryPersistencePort());
    }
}

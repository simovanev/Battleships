package com.exam.battleships;

import com.exam.battleships.models.enims.TypeEnum;
import com.exam.battleships.models.entities.CategoryEntity;
import com.exam.battleships.repositories.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategorySeed implements CommandLineRunner {
    private CategoryRepository categoryRepository;

    public CategorySeed(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.count() == 0) {
            List<CategoryEntity> categoryEntities = Arrays.stream(TypeEnum.values())
                    .map(CategoryEntity::new)
                    .toList();
            categoryRepository.saveAll(categoryEntities);
        }
    }
}

package com.exam.battleships.repositories;

import com.exam.battleships.models.enims.TypeEnum;
import com.exam.battleships.models.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository  extends JpaRepository<CategoryEntity,Long> {
    CategoryEntity findByName(TypeEnum name);
}

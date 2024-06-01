package com.exam.battleships.models.entities;

import com.exam.battleships.models.enims.TypeEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {
    @Column(unique = true)
    private TypeEnum name;
    @Column(columnDefinition = "LONG TEXT")
    private String description;
    @Enumerated(EnumType.STRING)
    public TypeEnum getName() {
        return name;
    }

    public void setName(TypeEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

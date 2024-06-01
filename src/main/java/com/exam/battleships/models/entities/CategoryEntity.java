package com.exam.battleships.models.entities;

import com.exam.battleships.models.enims.TypeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {
    @Column(unique = true)
    private TypeEnum name;
    @Lob
    private String description;

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

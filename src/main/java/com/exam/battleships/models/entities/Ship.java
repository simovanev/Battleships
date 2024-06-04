package com.exam.battleships.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

import java.util.Date;

@Entity
@Table(name = "ships")
public class Ship extends BaseEntity {
    @Size(min = 2, max = 10)
    @Column(unique = true, nullable = false)
    private String name;
    @Positive
    @Column(nullable = false)
    private long health;
    @Positive
    @Column(nullable = false)
    private long power;
    @Past
    @Column(nullable = false)
    private LocalDate created;
    @ManyToOne
    private CategoryEntity category;
    @ManyToOne
    private UserEntity user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getHealth() {
        return health;
    }

    public void setHealth(long health) {
        this.health = health;
    }

    public long getPower() {
        return power;
    }

    public void setPower(long power) {
        this.power = power;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}

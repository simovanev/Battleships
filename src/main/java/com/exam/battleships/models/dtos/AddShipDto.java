package com.exam.battleships.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class AddShipDto {
    @NotBlank
    private String name;
    @Positive
    private long power;
    @Positive
    private long health;
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate created;
    private int category=-1;

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    @Positive
    public long getPower() {
        return power;
    }

    public void setPower(@Positive long power) {
        this.power = power;
    }

    @Positive
    public long getHealth() {
        return health;
    }

    public void setHealth(@Positive long health) {
        this.health = health;
    }

    public @PastOrPresent LocalDate getCreated() {
        return created;
    }

    public void setCreated(@PastOrPresent LocalDate created) {
        this.created = created;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}

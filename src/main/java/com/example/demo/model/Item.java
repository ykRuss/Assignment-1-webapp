package com.example.demo.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Long id;

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Brand cannot be null")
    private Brand brand;

    @Min(value = 2022, message = "Year of creation must be more than 2021")
    private int yearOfCreation;

    @Positive
    @Min(value = 1001, message = "Price must be more than 1000")
    private double price;
}

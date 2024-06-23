package com.vunh.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Invoice {
    @NotNull
    private Integer id;
    @NotBlank
    private String customer;
    @NotNull
    @Min(1000)
    private Integer value;
    @NotBlank
    private String paymentMethod;
    private String status;
}

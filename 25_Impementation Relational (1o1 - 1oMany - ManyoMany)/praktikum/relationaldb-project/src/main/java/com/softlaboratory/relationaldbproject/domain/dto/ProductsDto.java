package com.softlaboratory.relationaldbproject.domain.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductsDto {
    private Long productId;
    private String productName;
    private BrandsDto brand;
    private CategoriesDto category;
    private Year modelYear;
    private double listPrice;
}

package com.softlaboratory.relationaldbproject.domain.dto;

import com.softlaboratory.relationaldbproject.domain.dao.BrandsDao;
import com.softlaboratory.relationaldbproject.domain.dao.CategoriesDao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Year;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProductsDto implements Serializable {
    private Long productId;
    private String productName;
    private BrandsDto brandsDto;
    private CategoriesDto categoriesDto;
    private Year modelYear;
    private double listPrice;
}

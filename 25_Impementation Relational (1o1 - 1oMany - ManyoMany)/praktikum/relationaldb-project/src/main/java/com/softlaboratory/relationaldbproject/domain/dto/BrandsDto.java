package com.softlaboratory.relationaldbproject.domain.dto;

import com.softlaboratory.relationaldbproject.domain.dao.ProductsDao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BrandsDto implements Serializable {
    private Long brandId;
    private String brandName;
    private List<ProductsDao> productsDaoList;
}

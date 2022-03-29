package com.softlaboratory.relationaldbproject.domain.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.Year;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@Entity
@Table(name = "products")
public class ProductsDao extends BaseDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private BrandsDao brandsDao;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoriesDao categoriesDao;

    @Column(name = "model_year", nullable = false)
    private Year modelYear;

    @Column(name = "listPrice", nullable = false)
    private double listPrice;
}

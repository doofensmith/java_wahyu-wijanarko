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

    @Column(name = "product_name")
    private String productName;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private BrandsDao brandsDao;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoriesDao categoriesDao;

    @Column(name = "model_year")
    private Year modelYear;

    @Column(name = "listPrice")
    private double listPrice;
}

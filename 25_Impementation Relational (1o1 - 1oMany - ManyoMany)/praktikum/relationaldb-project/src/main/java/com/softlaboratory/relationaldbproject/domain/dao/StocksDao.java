package com.softlaboratory.relationaldbproject.domain.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@Entity
@Table(name = "stocks")
public class StocksDao extends BaseDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
    private Long stockId;

    @OneToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductsDao productsDao;

    @Column(name = "quantity", nullable = false)
    private int quantity;

}

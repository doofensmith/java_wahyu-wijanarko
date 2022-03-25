package com.softlaboratory.springcrudproduct.domain.dao;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "product")
@SQLDelete(sql = "UPDATE product SET is_deleted = true WHERE id = ?")
@Where(clause = "is_deleted = false")
public class ProductDao extends BaseDao{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Dibuat otomatis oleh sistem.")
    private Long id;

    @Column(name = "name", nullable = false)
    @ApiModelProperty(notes = "Nama dari sebuah Product.", required = true, example = "Buku", value = "String")
    private String name;

    @Column(name = "description", nullable = false)
    @ApiModelProperty(notes = "Deskripsi dari Product.", required = true, example = "Ini deskripsi produk.", value = "String")
    private String description;

    @Column(name = "stock", nullable = false)
    @ApiModelProperty(notes = "Jumlah stok dari sebuah Product.", required = true, example = "99", value = "Integer")
    private int stock;

    @Column(name = "price", nullable = false)
    @ApiModelProperty(notes = "Harga dari sebuah Product.", required = true, example = "20999.9", value = "Float")
    private double price;

}

package com.softlaboratory.springcrudproduct.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    @ApiModelProperty(value = "id", notes = "Id dari sebuah Product, auto generate by system.", required = true)
    private Long id;

    @ApiModelProperty(value = "name", notes = "Nama dari sebuah Product.", example = "Buku", required = true)
    private String name;

    @ApiModelProperty(value = "description", notes = "Deskripsi dari sebuah Product.", example = "Ini deskripsi product.", required = true)
    private String description;

    @ApiModelProperty(value = "stock", notes = "Jumlah stok dari sebuah Product.", example = "100", required = true)
    private int stock;

    @ApiModelProperty(value = "price", notes = "Harga dari sebuah Product.", example = "29999.99", required = true)
    private double price;

}

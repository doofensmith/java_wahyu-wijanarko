package com.softlaboratory.nosqlmongodbproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document("product")
public class Product {

    @Id
    private String id;
    private String name;
    private double price;

}
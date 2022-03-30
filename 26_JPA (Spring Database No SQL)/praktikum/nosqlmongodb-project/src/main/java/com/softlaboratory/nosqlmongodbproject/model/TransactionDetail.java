package com.softlaboratory.nosqlmongodbproject.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document("transaction_detail")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TransactionDetail {

    @Id
    private String id;
    private String transactionId;
    private String productId;
    private int quantity;


}

package com.softlaboratory.springcrudproduct.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDto {

    private Long id;
    private String name;
    private String gender;

}

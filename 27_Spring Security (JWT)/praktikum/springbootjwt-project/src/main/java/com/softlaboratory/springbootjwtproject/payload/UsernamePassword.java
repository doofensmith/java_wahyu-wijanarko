package com.softlaboratory.springbootjwtproject.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsernamePassword {

    private String phone;
    private String password;

}

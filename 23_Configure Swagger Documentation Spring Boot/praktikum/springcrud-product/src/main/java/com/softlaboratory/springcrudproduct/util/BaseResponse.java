package com.softlaboratory.springcrudproduct.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass
public class BaseResponse {

    private LocalDateTime timestamp;
    private HttpStatus response_code;
    private String message;
    private Object data;

    @PrePersist
    void onCreate() {
        this.timestamp = LocalDateTime.now();
    }

}

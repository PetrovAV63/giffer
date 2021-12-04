package com.giffer.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class ChangerFallBack {
    private Boolean error;
    private Integer status;
    private String message;
    private String description;
}

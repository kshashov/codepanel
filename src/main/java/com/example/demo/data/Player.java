package com.example.demo.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {

    private String name;
    private Integer number;
    private Position position;
}

package com.pard.hw3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private String itemName;
    private int itemPrice;
    private int itemQuantity;
}

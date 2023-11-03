package com.pard.hw3.entity;

import com.pard.hw3.dto.ItemDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity(name = "item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String itemName;

    @Column(nullable = false)
    private int itemPrice;

    @Column(nullable = false)
    private int itemQuantity;

    @CreationTimestamp
    private Timestamp itemTime;

    public ItemEntity(ItemDto dto){
        this.itemName = dto.getItemName();
        this.itemPrice = dto.getItemPrice();
        this.itemQuantity = dto.getItemQuantity();
    }
}

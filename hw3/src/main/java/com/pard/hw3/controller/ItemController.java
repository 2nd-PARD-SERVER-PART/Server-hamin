package com.pard.hw3.controller;

import com.pard.hw3.dto.ItemDto;
import com.pard.hw3.dto.ResponseDto;
import com.pard.hw3.entity.ItemEntity;
import com.pard.hw3.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @GetMapping("/findAll")
    public  ResponseDto<List<ItemEntity>> getAllItem(){
        ResponseDto<List<ItemEntity>> result = itemService.getAllItem();
        return result;
    }

    @GetMapping("/itemListCheap")
    public ResponseDto<List<ItemEntity>> getCheapItemList(){
        ResponseDto<List<ItemEntity>> result = itemService.getItemListCheap();
        return result;
    }

    @GetMapping("/inStockItemList")
    public ResponseDto<List<ItemEntity>> getInStockItemList(){
        ResponseDto<List<ItemEntity>> result = itemService.getInStockItemList();
        return result;
    }

    @GetMapping("/itemListByName")
    public ResponseDto<List<ItemEntity>> getItemListByName(){
        ResponseDto<List<ItemEntity>> result = itemService.getItemListByName();
        return result;
    }

    @PostMapping("/item")
    public ResponseDto<ItemEntity> createItem(@RequestBody ItemDto dto){
        ResponseDto<ItemEntity> result = itemService.createItem(dto);
        return result;
    }

    @GetMapping("/item/{id}")
    public ResponseDto<ItemEntity> getItem(@PathVariable Integer id){
        ResponseDto<ItemEntity> result = itemService.getItem(id);
        return result;
    }

    @PatchMapping("/item/{id}")
    public ResponseDto<ItemEntity> updateItem(@PathVariable Integer id, @RequestBody ItemDto dto){
        ResponseDto<ItemEntity> result = itemService.updateItem(id, dto);
        return result;
    }

    @DeleteMapping("/item/{id}")
    public ResponseDto<?> deleteItem(@PathVariable Integer id){
        ResponseDto<?> result = itemService.deleteItem(id);
        return result;
    }
}

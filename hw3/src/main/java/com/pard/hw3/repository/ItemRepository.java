package com.pard.hw3.repository;

import com.pard.hw3.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {
    boolean existsByItemName(String itemName);


    //가격순 정렬
    List<ItemEntity> findALLByOrderByItemPriceAsc();

    //재고가 있는 물건만 리턴
    List<ItemEntity> findAllByItemQuantityGreaterThan(int itemQuantity);

    //이름순 정렬
    List<ItemEntity> findAllByOrderByItemNameAsc();



}

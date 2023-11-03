package com.pard.hw3.service;

import com.pard.hw3.dto.ItemDto;
import com.pard.hw3.dto.ResponseDto;
import com.pard.hw3.entity.ItemEntity;
import com.pard.hw3.repository.ItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public ResponseDto<List<ItemEntity>> getAllItem(){
        List<ItemEntity> result;
        try{
            result = itemRepository.findAll();
            return ResponseDto.setSuccess("find all success",result);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error");
        }
    }

    public ResponseDto<List<ItemEntity>> getItemListCheap(){
        List<ItemEntity> result;
        try{
            result = itemRepository.findALLByOrderByItemPriceAsc();
            return ResponseDto.setSuccess("find cheap item list success", result);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error");
        }
    }

    public ResponseDto<List<ItemEntity>> getInStockItemList(){
        List<ItemEntity> result;
        try {
            result = itemRepository.findAllByItemQuantityGreaterThan(0);
            return ResponseDto.setSuccess("find in stock item list success", result);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error");
        }
    }

    public ResponseDto<List<ItemEntity>> getItemListByName(){
        List<ItemEntity> result;
        try{
            result = itemRepository.findAllByOrderByItemNameAsc();
            return ResponseDto.setSuccess("find item list by name success", result);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error");
        }
    }

    public ResponseDto<ItemEntity> createItem(ItemDto dto){
        ItemEntity item = new ItemEntity(dto);
        String itemName = dto.getItemName();
        int itemPrice = dto.getItemPrice();
        int itemQuantity = dto.getItemQuantity();

        try{
            if(itemPrice >= 50000 || itemPrice < 0){
                return ResponseDto.setFailed("itemPrice is exceeded");
            }
            if(itemRepository.existsByItemName(itemName)){
                return ResponseDto.setFailed("itemName already exist");
            }
            if(itemQuantity < 0){
                return ResponseDto.setFailed("itemQuantity is incorrect");
            }

            itemRepository.save(item);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error");
        }

        return ResponseDto.setSuccess("create item success", item);
    }

    public ResponseDto<ItemEntity> getItem(int id){
        ItemEntity item;
        try{
            item = itemRepository.findById(id).get();
            return ResponseDto.setSuccess("get item success", item);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error");
        }
    }

    @Transactional
    public ResponseDto<ItemEntity> updateItem(int id, ItemDto dto){
        ItemEntity item;
        try{
            item = itemRepository.findById(id).get();
            if(!itemRepository.existsByItemName(dto.getItemName()) && dto.getItemName() != null && !dto.getItemName().isEmpty()) item.setItemName(dto.getItemName());
            if(dto.getItemPrice() >= 0 && dto.getItemPrice()<50000) item.setItemPrice(dto.getItemPrice());
            if(dto.getItemQuantity() >= 0) item.setItemQuantity(dto.getItemQuantity());
            return ResponseDto.setSuccess("update item success", item);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error");
        }
    }

    public ResponseDto<?> deleteItem(int id){
        try{
            if(itemRepository.existsById(id)){
                itemRepository.deleteById(id);
                return ResponseDto.setSuccess("item delete success", null);
            }
            else{
                return ResponseDto.setFailed("item not exist");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error");
        }
    }
}

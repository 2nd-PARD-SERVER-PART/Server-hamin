package com.homework2.hw2.repository;

import com.homework2.hw2.dto.ProductDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {
    public static final Map<Integer, ProductDto> productRepo = new HashMap<>();
    public static Integer idAutoIncrement = 1;

    public Integer save(ProductDto productDto){
        productDto.setId(idAutoIncrement);
        productRepo.put(idAutoIncrement, productDto);
        idAutoIncrement+=1;
        return idAutoIncrement-1;
    }

    public ProductDto findById(Integer id){
        return productRepo.get(id);
    }

    public List<ProductDto> findAll(){
        return new ArrayList<>(productRepo.values());
    }

    public ProductDto update(Integer id, ProductDto productDto){
        ProductDto findItem = findById(id);
        findItem.setName(productDto.getName());
        findItem.setPrice(productDto.getPrice());
        findItem.setAmount(productDto.getAmount());
        return productRepo.get(id);
    }

    public void delete(Integer id){
        productRepo.remove(id);
    }
}

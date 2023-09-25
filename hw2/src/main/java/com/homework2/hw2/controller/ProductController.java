package com.homework2.hw2.controller;

import com.homework2.hw2.dto.ProductDto;
import com.homework2.hw2.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public List<ProductDto> getAllProduct(){
        return productRepository.findAll();
    }

    @PostMapping("/product")
    public String createProduct(@RequestBody ProductDto productDto){
        Integer id = productRepository.save(productDto);
        log.info("id-'{}' added", id);
        return "success";
    }

    @GetMapping("/product/{id}")
    public ProductDto getProduct(@PathVariable Integer id){
        return productRepository.findById(id);
    }

    @PatchMapping("/product/{id}")
    public ProductDto updateProduct(@PathVariable Integer id, @RequestBody ProductDto productDto){
        productDto.setId(id);
        ProductDto productInfo = productRepository.update(id, productDto);
        log.info("id-'{}' updated", id);
        return productInfo;
    }

    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable Integer id){
        productRepository.delete(id);
        log.info("id-'{}' deleted",id);
        return "success";
    }


}

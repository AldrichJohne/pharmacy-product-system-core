package com.ajru.pharmacy_product_system.tables.service.impl;

import com.ajru.pharmacy_product_system.model.Classification;
import com.ajru.pharmacy_product_system.model.Product;
import com.ajru.pharmacy_product_system.reposiroty.ProductRepository;
import com.ajru.pharmacy_product_system.tables.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TableServiceImpl implements TableService {

    private final ProductRepository productRepository;

    @Autowired
    public TableServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return StreamSupport
                .stream(productRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    public List<Product>findProductByClass(long id){
        return productRepository.findProductByClass(id);
    }

}

package com.hbn.final_module_3.services;

import com.hbn.final_module_3.models.Product;

import java.util.List;

public interface IService {
    List<Product> findAll();

    void save(Product product);
}

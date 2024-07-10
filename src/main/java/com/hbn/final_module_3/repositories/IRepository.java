package com.hbn.final_module_3.repositories;

import com.hbn.final_module_3.models.Product;

import java.util.List;

public interface IRepository {
    List<Product> findAll();

    void save(Product product);
}

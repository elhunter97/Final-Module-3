package com.hbn.final_module_3.services.impl;

import com.hbn.final_module_3.models.Product;
import com.hbn.final_module_3.repositories.IRepository;
import com.hbn.final_module_3.repositories.impl.ProductRepository;
import com.hbn.final_module_3.services.IService;

import java.util.List;

public class ProductService implements IService {
    IRepository productRepository = new ProductRepository();
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
}

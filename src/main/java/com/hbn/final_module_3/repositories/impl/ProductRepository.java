package com.hbn.final_module_3.repositories.impl;

import com.hbn.final_module_3.models.Product;
import com.hbn.final_module_3.repositories.BaseRepository;
import com.hbn.final_module_3.repositories.IRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IRepository {
    private static List<Product> products;

    static {
        products = new ArrayList<>();
    }


    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String name;
        int price;
        double discount;
        int stock;
        try {
            ps = BaseRepository.getConnection().prepareStatement("select product_name,price,discount,stock from products");
            rs = ps.executeQuery();
            while (rs.next()) {
                name = rs.getString("product_name");
                price = rs.getInt("price");
                discount = rs.getDouble("discount");
                stock = rs.getInt("stock");
                products.add(new Product(name, price, discount, stock));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public void save(Product product) {
        PreparedStatement ps = null;
        try {
            ps=BaseRepository.getConnection().prepareStatement("insert into products(product_name,price,discount,stock) values(?,?,?,?)");
            ps.setString(1, product.getProductName());
            ps.setInt(2, product.getPrice());
            ps.setDouble(3, product.getDiscount());
            ps.setInt(4, product.getStock());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        products.add(product);
    }
}

package com.example.demo.dao;

import com.example.demo.model.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> findAll();
    public Product findById(int id);
    public Product save(Product product);
    public Product add(Product product);
    public String remove(int id);

}

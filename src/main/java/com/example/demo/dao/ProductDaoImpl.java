package com.example.demo.dao;

import com.example.demo.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImpl  implements ProductDao{
    public static List<Product> products = new ArrayList<>();
    static{
        Product peluche1 = new Product("peluche rein des neiges", 25, "", "tout violet");
        Product peluche2 = new Product("peluche coeur d'artichaut", 12, "", "tout vert");
        Product peluche3 = new Product("peluche pied de cochon", 18, "", "tout rose");
        products.add(peluche1);
        products.add(peluche2);
        products.add(peluche3);
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(int id) {
        Product product;
        for (Product p : products) {
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    @Override
    public Product add(Product product) {
        products.add(product);
        return product;
    }

    @Override
    public Product save(Product product) {
        if(this.findById(product.getId()) == null)
        {
            return null;
        }
        this.findById(product.getId()).update(product);
        return product;
    }

    @Override
    public String remove(int id) {
        var index = products.indexOf(findById(id));
        products.remove(index);
        return "le produit d'id " + id + " a bien été supprimé";
    }
}

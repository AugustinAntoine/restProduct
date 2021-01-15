package com.example.demo.controller;

import com.example.demo.dao.ProductDao;
import com.example.demo.dao.ProductDaoImpl;
import com.example.demo.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)

@RestController
public class ProductController {
    ProductDaoImpl context = new ProductDaoImpl();

    @RequestMapping(value="/peluches", method= RequestMethod.GET)
    //@GetMapping("/Produits")
    public List<Product> listeProduits() {
        return context.findAll();
    }

    @GetMapping(value = "/peluches/{id}")
    public Product afficherUnProduit(@PathVariable int id) {
        return context.findById(id);
    }

    @PostMapping(value = "/peluches/")
    public Product addProduct(@RequestBody Product product) {
        List<Product> lstProduct = context.findAll();
        int idLastProduct = 0;
        if(lstProduct.size() != 0)
        {
            idLastProduct = lstProduct.get(lstProduct.size() - 1).getId();
        }
        product.setId(idLastProduct + 1);
        this.context.add(product);
        return product;
    }

    @PutMapping(value = "/peluches/")
    public Product updProduct(@RequestBody Product product) {
        return context.save(product);
    }

    @DeleteMapping(value = "/peluches/")
    public String delProduct(@RequestParam int id) {
        return context.remove(id);
    }
}

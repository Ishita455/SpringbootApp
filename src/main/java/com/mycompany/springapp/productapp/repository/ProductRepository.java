package com.mycompany.springapp.productapp.repository;

import com.mycompany.springapp.productapp.model.ProductModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository {

    List<ProductModel> displayAllProducts = new ArrayList<>();

    public List<ProductModel> getAllProducts()
    {

        ProductModel pm = new ProductModel();
        pm.setId(1);
        pm.setTitle("Laptop");
        pm.setDescription("HP");
        pm.setPrice(35000.34);
        displayAllProducts.add(pm);

        pm = new ProductModel();
        pm.setId(2);
        pm.setTitle("Redmi 10 pro");
        pm.setDescription("Mobile");
        pm.setPrice(13000.45);
        displayAllProducts.add(pm);


        pm = new ProductModel();
        pm.setId(3);
        pm.setTitle("Apple X");
        pm.setDescription("mobile");
        pm.setPrice(45000.56);
        displayAllProducts.add(pm);

        return displayAllProducts;
    }
}

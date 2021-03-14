package com.mycompany.springapp.productapp.service;

import com.mycompany.springapp.productapp.model.ProductModel;
import com.mycompany.springapp.productapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    @Autowired
    private ProductRepository pr;
    public List<ProductModel> getAllProducts()
    {
        List<ProductModel> productModelList = pr.getAllProducts();
        return productModelList;
    }
}

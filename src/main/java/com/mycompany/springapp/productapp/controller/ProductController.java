package com.mycompany.springapp.productapp.controller;

import com.mycompany.springapp.productapp.model.ProductModel;
import com.mycompany.springapp.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService ps;
    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> getAllProducts() {

        List<ProductModel> list = ps.getAllProducts();
        return (new ResponseEntity<List<ProductModel>>(list, HttpStatus.OK));

    }
}

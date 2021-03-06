package com.mycompany.springapp.productapp.service;

import com.mycompany.springapp.productapp.exception.CreateNewProductException;
import com.mycompany.springapp.productapp.model.CategoryModel;
import com.mycompany.springapp.productapp.model.ProductModel;
import com.mycompany.springapp.productapp.repository.ProductCrudRepository;
import com.mycompany.springapp.productapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository pr;

    @Autowired
    private ProductCrudRepository pcr;

    public Iterable<ProductModel> getAllProducts()
    {
        Iterable<ProductModel> productModelList = pcr.findAll();//pr.getAllProducts();
        return productModelList;
    }
    public ProductModel createProduct(ProductModel productModel)
    {
        productModel = pcr.save(productModel);//pr.createProduct(productModel);
        return productModel;
    }
    public ProductModel deleteProduct(Long  id) {
        ProductModel productModel = null;
        Optional<ProductModel> optProduct = pcr.findById(id);
        if (optProduct.isPresent()) {
            ProductModel product = optProduct.get();
            pcr.delete(product);
            productModel = product;
        }
        else {
            System.out.println("No matching product found");
        }
        return productModel;
    }
   /* public ProductModel updateProduct(long id, ProductModel productModel)
    {
        ProductModel productModel1 = null;
        Optional<ProductModel> optProduct = pcr.findById(id);
        if (optProduct.isPresent()) {
            ProductModel product = optProduct.get();
            product.setTitle(productModel.getTitle());
            product.setDescription(productModel.getDescription());
            product.setPrice(productModel.getPrice());
            pcr.save(product);
            productModel1 = product;
        }
        else {
            System.out.println("No matching product found");
        }
        return productModel1;
    } */

    public ProductModel updateProduct(long id, ProductModel productModel)
    {
        ProductModel productModel1 = null;
        Optional<ProductModel> optProduct = pcr.findById(id);
        if (optProduct.isPresent()) {
            ProductModel product = optProduct.get();
            if(productModel.getPrice() != null) {
                product.setTitle(productModel.getTitle());
            }
            if(productModel.getDescription() != null) {
                product.setDescription(productModel.getDescription());
            }
            if(productModel.getPrice() != 0.0) {
                product.setPrice(productModel.getPrice());
            }
            pcr.save(product);
            productModel1 = product;
        }
        else {
            System.out.println("No matching product found");
        }
        return productModel1;
    }
    public List<ProductModel> searchProductByDescription(String description)
    {
        List<ProductModel> productsList = pr.searchProductByDescription(description);
        return productsList;
    }
    public List<ProductModel> searchProduct(String description,double fromPrice,double toPrice)
    {
        List<ProductModel> productsList = pr.searchProduct(description,fromPrice,toPrice);
        return productsList;
    }
  /*  public ProductModel searchProductById(long id)
    {
        ProductModel productModel = pr.searchProductById(id);
        return productModel;
    } */
   public ProductModel searchProductById(long id)
   {
       ProductModel productModel2 = null;
       Optional<ProductModel> optProduct = pcr.findById(id);
       if (optProduct.isPresent()) {
           ProductModel product = optProduct.get();
           productModel2 = product;
       }
       else {
           System.out.println("No matching product found");
       }
       return productModel2;
   }

   public ProductModel createNewProduct(ProductModel productModel) throws CreateNewProductException {
       Optional<ProductModel> product = pcr.findByDescription(productModel.getDescription());

       if(product.isPresent()){
           CreateNewProductException cpe = new CreateNewProductException("The product already exists!");
           throw cpe;
       }
       else {
           pcr.save(productModel);
       }
       return productModel;
   }

}

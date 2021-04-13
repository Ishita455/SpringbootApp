package com.mycompany.springapp.productapp.service;

import com.mycompany.springapp.productapp.model.CategoryModel;
import com.mycompany.springapp.productapp.repository.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryCrudRepository ccr;

    public Iterable<CategoryModel> getAllCategories() {
        Iterable<CategoryModel> categoryModelList = ccr.findAll();
        return categoryModelList;
    }

    public CategoryModel createCategory(CategoryModel categoryModel) {
        categoryModel = ccr.save(categoryModel);
        return categoryModel;
    }

    public CategoryModel deleteCategory(Long id) {
        CategoryModel categoryModel = null;
        Optional<CategoryModel> optCategory = ccr.findById(id);
        if (optCategory.isPresent()) {
            CategoryModel category = optCategory.get();
            ccr.delete(category);
            categoryModel = category;
        } else {
            System.out.println("No matching category found");
        }
        return categoryModel;
    }

    public CategoryModel updateCategory(Long id, CategoryModel categoryModel) {
        CategoryModel categoryModel1 = null;
        Optional<CategoryModel> optCategory = ccr.findById(id);
        if (optCategory.isPresent()) {
            CategoryModel category = optCategory.get();
            if (categoryModel.getCategoryName() != null) {
                category.setCategoryName(categoryModel.getCategoryName());
            }
            ccr.save(category);
            categoryModel1 = category;
        } else {
            System.out.println("No matching category found");
        }
        return categoryModel1;
    }
}

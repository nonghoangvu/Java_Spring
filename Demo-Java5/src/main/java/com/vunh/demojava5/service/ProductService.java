package com.vunh.demojava5.service;

import com.vunh.demojava5.entity.Category;
import com.vunh.demojava5.entity.Product;
import com.vunh.demojava5.repository.CategoriesRepository;
import com.vunh.demojava5.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoriesRepository productCategoriesRepository;

    public Page<Product> findAll(Pageable pageable, String keyword) {
        return productRepository.findAll(pageable, keyword);
    }

    public List<Category> getAllCategory() {
        return this.productCategoriesRepository.findAll();
    }

    public void storeProduct(Product product) {
        productRepository.save(product);
    }
}

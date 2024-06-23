package com.vunh.demojava5.repository;

import com.vunh.demojava5.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("FROM Product WHERE ((name LIKE %:keyword%) OR (category.name LIKE %:keyword%))")
    Page<Product> findAll(Pageable pageable, @Param("keyword") String keyword);
}

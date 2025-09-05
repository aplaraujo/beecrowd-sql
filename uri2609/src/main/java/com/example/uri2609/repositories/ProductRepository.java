package com.example.uri2609.repositories;

import com.example.uri2609.dto.CategorySumDTO;
import com.example.uri2609.entities.Product;
import com.example.uri2609.projection.CategorySumProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Consulta SQL
    @Query(nativeQuery = true, value = "SELECT categories.name, SUM (products.amount) AS sum " +
            "FROM categories " +
            "JOIN products ON categories.id = products.id_categories " +
            "GROUP BY categories.name")
    List<CategorySumProjection> search1();

    // Consulta JPQL
    @Query("SELECT new com.example.uri2609.dto.CategorySumDTO(obj.category.name, SUM(obj.amount)) " +
            "FROM Product obj " +
            "GROUP BY obj.category.name")
    List<CategorySumDTO> search2();
}

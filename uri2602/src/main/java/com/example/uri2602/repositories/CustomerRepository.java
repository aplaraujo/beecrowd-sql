package com.example.uri2602.repositories;

import com.example.uri2602.dto.CustomerMinDTO;
import com.example.uri2602.entities.Customer;
import com.example.uri2602.projections.CustomerMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Consulta SQL
    @Query(nativeQuery = true, value = "SELECT name FROM customers WHERE UPPER(state) = UPPER(:state)")
    List<CustomerMinProjection> search1(String state);

    // Consulta JPQL
    @Query("SELECT new com.example.uri2602.dto.CustomerMinDTO(obj.name) FROM Customer obj WHERE UPPER(obj.state) = UPPER(:state)")
    List<CustomerMinDTO> search2(String state);
}

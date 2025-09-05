package com.example.uri2990.repositories;

import com.example.uri2990.dto.EmpregadoDeptDTO;
import com.example.uri2990.entities.Empregado;
import com.example.uri2990.projections.EmpregadoDeptProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {

    // SQL
    @Query(nativeQuery = true, value = "SELECT empregados.cpf, empregados.enome, departamentos.dnome " +
            "FROM empregados " +
            "JOIN departamentos ON empregados.dnumero = departamentos.dnumero " +
            "LEFT JOIN trabalha ON trabalha.cpf_emp = empregados.cpf " +
            "WHERE trabalha.cpf_emp IS NULL " +
            "ORDER BY empregados.cpf")
    List<EmpregadoDeptProjection> search1();

    // JPQL
    @Query("SELECT new com.example.uri2990.dto.EmpregadoDeptDTO(obj.cpf, obj.enome, obj.departamento.dnome) " +
            "FROM Empregado obj " +
            "WHERE obj.cpf NOT IN ( " +
            " SELECT obj.cpf FROM Empregado obj " +
            " JOIN obj.projetosOndeTrabalha " +
            ") " +
            "ORDER BY obj.cpf")
    List<EmpregadoDeptDTO> search2();
}

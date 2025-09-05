package com.example.uri2621;

import com.example.uri2621.dto.ProductMinDTO;
import com.example.uri2621.projections.ProductMinProjection;
import com.example.uri2621.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2621Application implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
		SpringApplication.run(Uri2621Application.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        // SQL
        List<ProductMinProjection> list = productRepository.search1(10, 20, "P");
        List<ProductMinDTO> result1 = list.stream().map(prod -> new ProductMinDTO(prod)).collect(Collectors.toList());

        // JPQL
        List<ProductMinDTO> result2 = productRepository.search2(10, 20, "P");

        System.out.println();
        System.out.println("-------------------------");
        System.out.println();
        System.out.println("RESULTADO SQL");
        System.out.println();
        for(ProductMinDTO obj: result1) {
            System.out.println(obj);
        }
        System.out.println();
        System.out.println();
        System.out.println("RESULTADO JPQL");
        System.out.println();
        for(ProductMinDTO obj: result2) {
            System.out.println(obj);
        }
        System.out.println();
        System.out.println();
        System.out.println("-------------------------");
        System.out.println();
    }
}

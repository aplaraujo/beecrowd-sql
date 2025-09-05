package com.example.uri2609;

import com.example.uri2609.dto.CategorySumDTO;
import com.example.uri2609.projection.CategorySumProjection;
import com.example.uri2609.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2609Application implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2609Application.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        // SQL
        List<CategorySumProjection> list = productRepository.search1();
        List<CategorySumDTO> result1 = list.stream().map(cat -> new CategorySumDTO(cat)).collect(Collectors.toList());

        // JPQL
        List<CategorySumDTO> result2 = productRepository.search2();

        System.out.println();
        System.out.println("-------------------------");
        System.out.println();
        System.out.println("RESULTADO SQL");
        System.out.println();
        for(CategorySumDTO obj: result1) {
            System.out.println(obj);
        }
        System.out.println();
        System.out.println("RESULTADO JPQL");
        System.out.println();
        for(CategorySumDTO obj: result2) {
            System.out.println(obj);
        }
        System.out.println();
        System.out.println();
        System.out.println("-------------------------");
        System.out.println();
    }
}

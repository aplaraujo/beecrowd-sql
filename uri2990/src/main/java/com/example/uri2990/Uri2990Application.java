package com.example.uri2990;

import com.example.uri2990.dto.EmpregadoDeptDTO;
import com.example.uri2990.projections.EmpregadoDeptProjection;
import com.example.uri2990.repositories.EmpregadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2990Application  implements CommandLineRunner {
    @Autowired
    private EmpregadoRepository empregadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2990Application.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        List<EmpregadoDeptProjection> list = empregadoRepository.search1();
        List<EmpregadoDeptDTO> result1 = list.stream().map(emp -> new EmpregadoDeptDTO(emp)).collect(Collectors.toList());

        // JPQL
        List<EmpregadoDeptDTO> result2 = empregadoRepository.search2();

        System.out.println();
        System.out.println("-------------------------");
        System.out.println();
        System.out.println("RESULTADO SQL");
        System.out.println();
        for(EmpregadoDeptDTO obj: result1) {
            System.out.println(obj);
        }
        System.out.println();
        System.out.println();
        System.out.println("RESULTADO JPQL");
        System.out.println();
        for(EmpregadoDeptDTO obj: result2) {
            System.out.println(obj);
        }
        System.out.println();
        System.out.println("-------------------------");
        System.out.println();
    }
}

package com.example.uri2737;

import com.example.uri2737.dto.LawyerMinDTO;
import com.example.uri2737.projections.LawyerMinProjection;
import com.example.uri2737.repositories.LawyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2737Application implements CommandLineRunner {
    @Autowired
    private LawyerRepository lawyerRepository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2737Application.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        List<LawyerMinProjection> list = lawyerRepository.search1();
        List<LawyerMinDTO> result1 = list.stream().map(law -> new LawyerMinDTO(law)).collect(Collectors.toList());

        System.out.println();
        System.out.println("-------------------------");
        System.out.println();
        System.out.println("RESULTADO SQL");
        System.out.println();
        for(LawyerMinDTO  obj: result1) {
            System.out.println(obj);
        }
        System.out.println();
        System.out.println();
        System.out.println("-------------------------");
        System.out.println();
    }
}

package com.example.uri2611;

import com.example.uri2611.dto.MovieMinDTO;
import com.example.uri2611.projections.MovieMinProjection;
import com.example.uri2611.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {
    @Autowired
    private MovieRepository movieRepository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        // SQL
        List<MovieMinProjection> list = movieRepository.search1("Action");
        List<MovieMinDTO> result1 = list.stream().map(movie -> new MovieMinDTO(movie)).collect(Collectors.toList());

        // JPQL
        List<MovieMinDTO> result2 = movieRepository.search2("Action");

        System.out.println();
        System.out.println("-------------------------");
        System.out.println();
        System.out.println("RESULTADO SQL");
        System.out.println();
        for(MovieMinDTO obj: result1) {
            System.out.println(obj);
        }
        System.out.println();
        System.out.println();
        System.out.println("RESULTADO JPQL");
        System.out.println();
        for(MovieMinDTO obj: result2) {
            System.out.println(obj);
        }
        System.out.println();
        System.out.println("-------------------------");
        System.out.println();
    }
}

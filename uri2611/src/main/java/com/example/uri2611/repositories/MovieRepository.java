package com.example.uri2611.repositories;

import com.example.uri2611.dto.MovieMinDTO;
import com.example.uri2611.entities.Movie;
import com.example.uri2611.projections.MovieMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    // Consulta SQL
    @Query(nativeQuery = true, value = "SELECT movies.id, movies.name " +
            "FROM movies " +
            "JOIN genres ON movies.id_genres = genres.id " +
            "WHERE genres.description = :genreName")
    List<MovieMinProjection> search1(String genreName);

    // Consulta JPQL
    @Query("SELECT new com.example.uri2611.dto.MovieMinDTO(obj.id, obj.name) " +
            "FROM Movie obj " +
            "WHERE obj.genre.description = :genreName")
    List<MovieMinDTO> search2(String genreName);
}

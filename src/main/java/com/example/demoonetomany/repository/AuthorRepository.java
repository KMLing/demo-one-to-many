package com.example.demoonetomany.repository;

import com.example.demoonetomany.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface AuthorRepository extends JpaRepository<Author,Long> {

    @Query("select a from Author a JOIN fetch a.books where a.name=?1")
    Author fetchByName(String name);

}

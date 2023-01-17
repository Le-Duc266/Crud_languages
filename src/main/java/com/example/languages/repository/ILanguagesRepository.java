package com.example.languages.repository;

import com.example.languages.entities.Languages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILanguagesRepository extends JpaRepository<Languages,Integer> {
    Languages findBycode(String code);
}

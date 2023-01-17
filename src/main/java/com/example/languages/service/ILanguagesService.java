package com.example.languages.service;

import com.example.languages.dto.LanguagesInputDto;
import com.example.languages.dto.LanguagesOutputDto;
import com.example.languages.entities.Languages;

import java.util.List;
import java.util.Optional;

public interface ILanguagesService {

    List<LanguagesOutputDto> getAll();
    Languages getLanguageByCode(String code);
    LanguagesOutputDto create(LanguagesInputDto inputDto);
    Languages update (int id, LanguagesInputDto inputDto);
    Languages delete(int id);



}

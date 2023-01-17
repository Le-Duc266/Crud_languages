package com.example.languages.mapper;


import com.example.languages.dto.LanguagesInputDto;
import com.example.languages.dto.LanguagesOutputDto;
import com.example.languages.entities.Languages;
import org.mapstruct.Mapper;


@Mapper
public interface LanguagesMapper {
    LanguagesOutputDto languagesToLanguagesOutput(Languages languages);

    Languages outputDtoToEntity(LanguagesOutputDto outputDto);

    Languages entityToInputDto(LanguagesInputDto inputDto);


}

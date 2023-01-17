package com.example.languages.service.impl;

import com.example.languages.exception.ExceptionHandle;
import com.example.languages.exception.ExceptionRequest;
import com.example.languages.mapper.LanguagesMapper;
import com.example.languages.dto.LanguagesInputDto;
import com.example.languages.dto.LanguagesOutputDto;
import com.example.languages.entities.Languages;
import com.example.languages.repository.ILanguagesRepository;
import com.example.languages.service.ILanguagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LanguagesServiceimpl implements ILanguagesService {

    @Autowired
    private LanguagesMapper languagesMapper;
    @Autowired
    private ILanguagesRepository repository;

    @Override
    public List<LanguagesOutputDto> getAll() {
        return repository.findAll().stream().map(languagesMapper::languagesToLanguagesOutput).collect(Collectors.toList());
    }

    @Override
    public Languages getLanguageByCode(String code) {
        return repository.findBycode(code);
    }

    @Override
    public LanguagesOutputDto create(LanguagesInputDto inputDto) {

            if (getLanguageByCode(inputDto.getCode()) == null){
                Languages languages = languagesMapper.entityToInputDto(inputDto);
                languages.setCreated_at(Timestamp.valueOf(ZonedDateTime.now().toLocalDateTime()));
                 repository.save(languages);
                 return languagesMapper.languagesToLanguagesOutput(languages);
            }else {
                throw new ExceptionHandle("Code đã tồn tại trong database");
            }
    }

    @Override
    public Languages update(int id, LanguagesInputDto inputDto) {
        Languages languages = repository.findById(id).get();
        if (languages != null) {
            languages.setName(inputDto.getName());
            languages.setFlag(inputDto.getFlag());
            languages.setCode(inputDto.getCode());
            languages.setDescription(inputDto.getDescription());
            languages.setId(id);
            languages.setUpdated_at(Timestamp.valueOf(ZonedDateTime.now().toLocalDateTime()));
            return repository.save(languages);
        }
        return null;
    }

    @Override
    public Languages delete(int id) {
        Languages languages = repository.findById(id).get();
        if (languages != null) {
            languages.setDeleted_at(Timestamp.valueOf(ZonedDateTime.now().toLocalDateTime()));
            return repository.save(languages);
        } else {
            System.out.println("Không tìm thấy id");
        }
        return null;
    }


}

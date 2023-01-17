package com.example.languages.controller;

import com.example.languages.dto.LanguagesInputDto;
import com.example.languages.dto.LanguagesOutputDto;
import com.example.languages.entities.Languages;
import com.example.languages.service.ILanguagesService;
import com.example.languages.service.impl.LanguagesServiceimpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/languages")
public class LanguageController {

    private final ILanguagesService service;
    public LanguageController(ILanguagesService service) {
        this.service = service;
    }

    @GetMapping
    public List<LanguagesOutputDto> getAll() {
        return service.getAll();
    }

    @PostMapping
    public LanguagesOutputDto create(@RequestBody @Valid LanguagesInputDto inputDto) {

        return service.create(inputDto);

    }

    @PutMapping("/{id}")
    public Languages update(@PathVariable("id") int id, @RequestBody LanguagesInputDto inputDto) {
        return service.update(id,inputDto);
    }

    @DeleteMapping("/{id}")
    public Languages delete(@PathVariable("id") int id) {
        return service.delete(id);
    }
}

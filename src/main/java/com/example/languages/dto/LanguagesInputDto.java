package com.example.languages.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Data
public class LanguagesInputDto implements Serializable {
    private String flag;
    @Pattern(regexp = "^[a-zA-Z0-9 ]{0,10}+$", message = "Code không chứa kí tự đặc biệt")
    private String code;
    @Length(max = 250, message = "Tên không quá 250 kí tự")
    private String name;
    private String description;
    private Timestamp created_at;
}

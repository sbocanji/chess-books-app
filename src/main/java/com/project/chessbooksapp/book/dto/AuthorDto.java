package com.project.chessbooksapp.book.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthorDto {
    private String playerName;
    private boolean active;
    private boolean worldChampion;
    private String nationality;
}
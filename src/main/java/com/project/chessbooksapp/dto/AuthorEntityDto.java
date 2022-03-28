package com.project.chessbooksapp.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthorEntityDto {
    private String playerName;
    private boolean active;
    private boolean worldChampion;
    private String nationality;
}

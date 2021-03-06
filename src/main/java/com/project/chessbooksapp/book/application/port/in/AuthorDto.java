package com.project.chessbooksapp.book.application.port.in;


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
    private Boolean active;
    private Boolean worldChampion;
    private String nationality;
}

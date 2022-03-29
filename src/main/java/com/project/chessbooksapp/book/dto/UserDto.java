package com.project.chessbooksapp.book.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UserDto {
    private String username;
    private String email;
    private boolean preferenceOfActive;
    private boolean preferenceOfExWorldChampion;
}

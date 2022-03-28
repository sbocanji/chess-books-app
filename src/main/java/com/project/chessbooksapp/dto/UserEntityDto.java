package com.project.chessbooksapp.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserEntityDto {
    String username;
    String email;
    String preferenceOfAuthor;
}

package com.project.chessbooksapp.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {
    String username;
    String email;
    String preferenceOfAuthor;
}

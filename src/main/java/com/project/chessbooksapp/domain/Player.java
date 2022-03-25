package com.project.chessbooksapp.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Player {
    private String playerName;
    private char worldChampion;
    private String nationality;
    private char active;

}

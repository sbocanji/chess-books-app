package com.project.chessbooksapp.book.domain;

import com.project.chessbooksapp.commons.Column;

import java.util.Arrays;

public enum AuthorColumns implements Column {
    PLAYER_NAME("playerName", true),
    ACTIVE("active", true),
    WORLD_CHAMPION("worldChampion", true),
    NATIONALITY("nationality", true);

    private final String columnName;
    private final boolean mandatory;

    AuthorColumns(String columnName, boolean mandatory) {
        this.columnName = columnName;
        this.mandatory = mandatory;
    }

    @Override
    public String getColumnName() {
        return columnName;
    }

    @Override
    public boolean isMandatory() {
        return mandatory;
    }

    public static AuthorColumns getByName(String name) {
        return Arrays.stream(values()).filter(value -> value.getColumnName().equals(name)).findAny().orElseThrow(IllegalArgumentException::new);
    }
}

package com.project.chessbooksapp.services.readers.authors;

import com.project.chessbooksapp.services.readers.CSVColumns;

import java.util.Arrays;

public enum AuthorCSVColumns implements CSVColumns {
    PLAYER_NAME("playerName", true),
    ACTIVE("active", true),
    WORLD_CHAMPION("worldChampion", true),
    NATIONALITY("nationality", true);

    private final String columnName;
    private final boolean mandatory;

    AuthorCSVColumns(String columnName, boolean mandatory) {
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

    public static AuthorCSVColumns getByName(String name) {
        return Arrays.stream(values()).filter(value -> value.getColumnName().equals(name)).findAny().orElseThrow(IllegalArgumentException::new);
    }
}

package com.project.chessbooksapp.book.domain;

import com.project.chessbooksapp.commons.Column;

import java.util.Arrays;

public enum BookColumns implements Column {
    ID("id", true),
    NAME("bookName", true),
    AUTHOR("author", true),
    STORES("stores", true);

    private final String columnName;
    private final boolean mandatory;

    BookColumns(String columnName, boolean mandatory) {
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

    public static BookColumns getByName(String name) {
        return Arrays.stream(values()).filter(value -> value.getColumnName().equals(name)).findAny().orElseThrow(IllegalArgumentException::new);
    }
}

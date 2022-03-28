package com.project.chessbooksapp.services.readers.books;

import com.project.chessbooksapp.services.readers.Column;

import java.util.Arrays;

public enum BookCSVColumns implements Column {
    ID("id", true),
    NAME("bookName", true),
    AUTHOR("author", true);

    private final String columnName;
    private final boolean mandatory;

    BookCSVColumns(String columnName, boolean mandatory) {
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

    public static BookCSVColumns getByName(String name) {
        return Arrays.stream(values()).filter(value -> value.getColumnName().equals(name)).findAny().orElseThrow(IllegalArgumentException::new);
    }
}

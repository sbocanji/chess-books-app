package com.project.chessbooksapp.services.readers.authors;

import com.project.chessbooksapp.services.readers.CSVColumns;

public enum AuthorCSVColumns implements CSVColumns {
    ;

    @Override
    public String getColumnName() {
        return null;
    }

    @Override
    public boolean isMandatory() {
        return false;
    }
}

package com.project.chessbooksapp.commons;

import com.project.chessbooksapp.book.application.parsers.factories.FileType;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public interface ParserService<T> {

    List<T> parse(InputStream inputStream, FileType fileType);

}

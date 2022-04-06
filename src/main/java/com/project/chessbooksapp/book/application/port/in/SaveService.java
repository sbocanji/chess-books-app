package com.project.chessbooksapp.book.application.port.in;

import com.project.chessbooksapp.book.application.parsers.factories.FileType;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public interface SaveService<T> {

    List<T> save(InputStream inputStream, FileType fileType);

}

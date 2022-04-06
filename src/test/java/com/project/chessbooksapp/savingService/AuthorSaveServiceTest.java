package com.project.chessbooksapp.savingService;

import com.project.chessbooksapp.book.application.parsers.factories.FileType;
import com.project.chessbooksapp.book.application.service.SaveAuthorServiceImpl;
import com.project.chessbooksapp.commons.LocalReader;
import com.project.chessbooksapp.commons.Reader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;

@SpringBootTest
public class AuthorSaveServiceTest {

    @Autowired
    SaveAuthorServiceImpl authorService;
    Reader reader = new LocalReader();
    InputStream inputStream = reader.readFile("igraci");

    @Test
    void testAuthorSaveService() {
        authorService.save(inputStream, FileType.CSV);
    }

}

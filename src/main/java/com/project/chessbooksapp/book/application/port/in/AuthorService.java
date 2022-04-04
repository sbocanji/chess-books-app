package com.project.chessbooksapp.book.application.port.in;

import com.project.chessbooksapp.commons.ParserService;
import org.springframework.stereotype.Service;

@Service
public interface AuthorService extends ParserService<AuthorDto> {
}

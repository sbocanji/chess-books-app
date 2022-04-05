package com.project.chessbooksapp.fileImport;

import com.project.chessbooksapp.book.application.parsers.factories.AuthorParserFactory;
import com.project.chessbooksapp.book.application.parsers.factories.FileType;
import com.project.chessbooksapp.book.application.parsers.factories.ParserFactory;
import com.project.chessbooksapp.commons.Parser;
import com.project.chessbooksapp.book.application.port.in.AuthorDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AuthorParserTest {
    Parser<AuthorDto> authorDtoParser;
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    ParserFactory<AuthorDto> authorParserFactory = new AuthorParserFactory();

    @Test
    void testCSVAuthorParser() {
        AuthorDto firstAuthor = new AuthorDto("Bobby Fischer", false, true, "USA");
        AuthorDto secondAuthor = new AuthorDto("Anatoly Karpov", false, true, "Russia");

        authorDtoParser = authorParserFactory.getParser(FileType.CSV);
        List<AuthorDto> authors = authorDtoParser.readEntities(classloader.getResourceAsStream("igraci"));
        assertThat(authors).hasSize(30);
        assertThat(authors.get(0).getNationality()).isEqualTo(firstAuthor.getNationality());
        assertThat(authors.get(0).getPlayerName()).isEqualTo(firstAuthor.getPlayerName());
        assertThat(authors.get(0).getActive()).isEqualTo(firstAuthor.getActive());
        assertThat(authors.get(0).getWorldChampion()).isEqualTo(firstAuthor.getWorldChampion());
        assertThat(authors.get(1).getPlayerName()).isEqualTo(secondAuthor.getPlayerName());
        assertThat(authors.get(1).getNationality()).isEqualTo(secondAuthor.getNationality());
        assertThat(authors.get(1).getActive()).isEqualTo(secondAuthor.getActive());
        assertThat(authors.get(1).getWorldChampion()).isEqualTo(secondAuthor.getWorldChampion());
        assertThatThrownBy(() -> authorDtoParser.readEntities(classloader.getResourceAsStream("igraciWithError.csv"))).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Invalid input.");
    }

    @Test
    void testJsonAuthorParser() {
        AuthorDto firstAuthor = new AuthorDto("Bobby Fischer", false, true, "USA");
        AuthorDto secondAuthor = new AuthorDto("Anatoly Karpov", false, true, "Russia");

        authorDtoParser = authorParserFactory.getParser(FileType.JSON);
        List<AuthorDto> authors = authorDtoParser.readEntities(classloader.getResourceAsStream("igraciJson.json"));
        assertThat(authors).hasSize(30);
        assertThat(authors.get(0).getNationality()).isEqualTo(firstAuthor.getNationality());
        assertThat(authors.get(0).getPlayerName()).isEqualTo(firstAuthor.getPlayerName());
        assertThat(authors.get(0).getActive()).isEqualTo(firstAuthor.getActive());
        assertThat(authors.get(0).getWorldChampion()).isEqualTo(firstAuthor.getWorldChampion());
        assertThat(authors.get(1).getPlayerName()).isEqualTo(secondAuthor.getPlayerName());
        assertThat(authors.get(1).getNationality()).isEqualTo(secondAuthor.getNationality());
        assertThat(authors.get(1).getActive()).isEqualTo(secondAuthor.getActive());
        assertThat(authors.get(1).getWorldChampion()).isEqualTo(secondAuthor.getWorldChampion());
        assertThatThrownBy(() -> authorDtoParser.readEntities(classloader.getResourceAsStream("igraciWithError.json"))).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Invalid input.");
    }

    @Test
    void testExcelAuthorParser() {
        AuthorDto firstAuthor = new AuthorDto("Bobby Fischer", false, true, "USA");
        AuthorDto secondAuthor = new AuthorDto("Anatoly Karpov", false, true, "Russia");

        authorDtoParser = authorParserFactory.getParser(FileType.XLSX);
        List<AuthorDto> authors = authorDtoParser.readEntities(classloader.getResourceAsStream("igraciXlsx.xlsx"));
        assertThat(authors).hasSize(30);
        assertThat(authors.get(0).getNationality()).isEqualTo(firstAuthor.getNationality());
        assertThat(authors.get(0).getPlayerName()).isEqualTo(firstAuthor.getPlayerName());
        assertThat(authors.get(0).getActive()).isEqualTo(firstAuthor.getActive());
        assertThat(authors.get(0).getWorldChampion()).isEqualTo(firstAuthor.getWorldChampion());
        assertThat(authors.get(1).getPlayerName()).isEqualTo(secondAuthor.getPlayerName());
        assertThat(authors.get(1).getNationality()).isEqualTo(secondAuthor.getNationality());
        assertThat(authors.get(1).getActive()).isEqualTo(secondAuthor.getActive());
        assertThat(authors.get(1).getWorldChampion()).isEqualTo(secondAuthor.getWorldChampion());
        assertThatThrownBy(() -> authorDtoParser.readEntities(classloader.getResourceAsStream("igraciWithError.xlsx"))).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Invalid input.");
    }
}

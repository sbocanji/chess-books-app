package com.project.chessbooksapp.fileImport;

import com.project.chessbooksapp.book.application.service.AuthorCSVParser;
import com.project.chessbooksapp.book.application.service.AuthorXlsxParser;
import com.project.chessbooksapp.book.application.service.BookCSVParser;
import com.project.chessbooksapp.book.application.service.BookXlsxParser;
import com.project.chessbooksapp.commons.JsonParser;
import com.project.chessbooksapp.commons.Parser;
import com.project.chessbooksapp.commons.XlsxParser;
import com.project.chessbooksapp.dto.AuthorDto;
import com.project.chessbooksapp.dto.BookDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AuthorParserTest {
    Parser<AuthorDto> authorDtoParser;
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();

    @Test
    void testCSVAuthorParser() {
        AuthorDto firstAuthor = new AuthorDto("Bobby Fischer", false, true, "USA");
        AuthorDto secondAuthor = new AuthorDto("Anatoly Karpov", false, true, "Russia");

        authorDtoParser = new AuthorCSVParser();
        List<AuthorDto> authors = authorDtoParser.readEntities(classloader.getResourceAsStream("igraci"));
        assertThat(authors).hasSize(30);
        assertThat(authors.get(0).getNationality()).isEqualTo(firstAuthor.getNationality());
        assertThat(authors.get(0).getPlayerName()).isEqualTo(firstAuthor.getPlayerName());
        assertThat(authors.get(0).isActive()).isEqualTo(firstAuthor.isActive());
        assertThat(authors.get(0).isWorldChampion()).isEqualTo(firstAuthor.isWorldChampion());
        assertThat(authors.get(1).getPlayerName()).isEqualTo(secondAuthor.getPlayerName());
        assertThat(authors.get(1).getNationality()).isEqualTo(secondAuthor.getNationality());
        assertThat(authors.get(1).isActive()).isEqualTo(secondAuthor.isActive());
        assertThat(authors.get(1).isWorldChampion()).isEqualTo(secondAuthor.isWorldChampion());
        assertThatThrownBy(() -> authorDtoParser.readEntities(classloader.getResourceAsStream("igraciWithError.csv"))).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Invalid input.");
    }

    @Test
    void testJsonAuthorParser() {
        AuthorDto firstAuthor = new AuthorDto("Bobby Fischer", false, true, "USA");
        AuthorDto secondAuthor = new AuthorDto("Anatoly Karpov", false, true, "Russia");

        authorDtoParser = new JsonParser<>(AuthorDto.class);
        List<AuthorDto> authors = authorDtoParser.readEntities(classloader.getResourceAsStream("igraciJson.json"));
        assertThat(authors).hasSize(30);
        assertThat(authors.get(0).getNationality()).isEqualTo(firstAuthor.getNationality());
        assertThat(authors.get(0).getPlayerName()).isEqualTo(firstAuthor.getPlayerName());
        assertThat(authors.get(0).isActive()).isEqualTo(firstAuthor.isActive());
        assertThat(authors.get(0).isWorldChampion()).isEqualTo(firstAuthor.isWorldChampion());
        assertThat(authors.get(1).getPlayerName()).isEqualTo(secondAuthor.getPlayerName());
        assertThat(authors.get(1).getNationality()).isEqualTo(secondAuthor.getNationality());
        assertThat(authors.get(1).isActive()).isEqualTo(secondAuthor.isActive());
        assertThat(authors.get(1).isWorldChampion()).isEqualTo(secondAuthor.isWorldChampion());
//        assertThatThrownBy(() -> authorDtoParser.readEntities(classloader.getResourceAsStream("knjigeWithError.json"))).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Invalid input.");
    }

    @Test
    void testExcelAuthorParser() {
        AuthorDto firstAuthor = new AuthorDto("Bobby Fischer", false, true, "USA");
        AuthorDto secondAuthor = new AuthorDto("Anatoly Karpov", false, true, "Russia");

        authorDtoParser = new AuthorXlsxParser();
        List<AuthorDto> authors = authorDtoParser.readEntities(classloader.getResourceAsStream("igraciXlsx.xlsx"));
        assertThat(authors).hasSize(30);
        assertThat(authors.get(0).getNationality()).isEqualTo(firstAuthor.getNationality());
        assertThat(authors.get(0).getPlayerName()).isEqualTo(firstAuthor.getPlayerName());
        assertThat(authors.get(0).isActive()).isEqualTo(firstAuthor.isActive());
        assertThat(authors.get(0).isWorldChampion()).isEqualTo(firstAuthor.isWorldChampion());
        assertThat(authors.get(1).getPlayerName()).isEqualTo(secondAuthor.getPlayerName());
        assertThat(authors.get(1).getNationality()).isEqualTo(secondAuthor.getNationality());
        assertThat(authors.get(1).isActive()).isEqualTo(secondAuthor.isActive());
        assertThat(authors.get(1).isWorldChampion()).isEqualTo(secondAuthor.isWorldChampion());
        assertThatThrownBy(() -> authorDtoParser.readEntities(classloader.getResourceAsStream("igraciWithError.xlsx"))).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Invalid input.");
    }
}

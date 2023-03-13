package com.musti.mylibrary.service;

import com.musti.mylibrary.dao.AuthorDAO;
import com.musti.mylibrary.entity.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AuthorServiceImplTest {

    @Autowired
    public AuthorService authorService;

    @MockBean
    public AuthorDAO authorDAO;

    @Test
    public void testFindAll(){

        // given
        List<Author> authors = new ArrayList<>();
        authors.add(new Author("Gogol"));
        authors.add(new Author("George Orwell"));

        when(authorDAO.findAll()).thenReturn(authors);

        // when
        List<Author> result = authorDAO.findAll();

        // then
        assertEquals(authors,result);
        assertNotNull(result);
    }

    @Test
    public void testFindById(){

        // given
        Author author = new Author("Gogol");

        when(authorDAO.findById(anyInt())).thenReturn(author);

        // when
        Author result = authorDAO.findById(anyInt());

        // then
        assertNotNull(result);
    }

    @Test
    public void saveAuthor(){

        // given
        Author author = new Author("Gogol");

        when(authorDAO.save(any())).thenReturn(author);

        // when
        Author result = authorDAO.save(any());

        // then
        assertNotNull(result);
    }

    @Test
    public void deleteAuthorById(){

        // given
        doNothing().when(authorDAO).deleteById(anyInt());

        // when
        authorDAO.deleteById(anyInt());
        // then
        verify(authorDAO, times(1)).deleteById(anyInt());
    }
}

package com.musti.mylibrary.service;

import com.musti.mylibrary.dao.BookDAO;
import com.musti.mylibrary.entity.Author;
import com.musti.mylibrary.entity.Book;
import com.musti.mylibrary.model.BookResponseDTO;
import com.musti.mylibrary.model.Status;
import com.musti.mylibrary.model.UpdateStatusDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BookServiceImplTest {

    @Autowired
    public BookService bookService;

    @MockBean
    public BookDAO bookDAO;

    @Test
    public void testUpdateBookStatusById(){
        // given
        Book book = new Book("Oblomov",650,0);
        book.setAuthor(new Author("Goncarov"));
        when(bookDAO.findById(anyInt())).thenReturn(book);

        // when
        BookResponseDTO result = bookService.updateBookStatusById(new UpdateStatusDTO(anyInt(), Status.readed));

        // then
        assertNotNull(result);
        assertEquals(Status.readed.ordinal(),result.getStatus());
    }
}

package com.musti.mylibrary.service;

import com.musti.mylibrary.dao.BookDAO;
import com.musti.mylibrary.entity.Author;
import com.musti.mylibrary.entity.Book;
import com.musti.mylibrary.entity.Type;
import com.musti.mylibrary.model.BookResponseDTO;
import com.musti.mylibrary.model.CreateBookRequestDTO;
import com.musti.mylibrary.model.Status;
import com.musti.mylibrary.model.UpdateStatusDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private BookDAO bookDAO;
    private AuthorService authorService;

    private TypeService typeService;


    public BookServiceImpl(BookDAO theBookDAO, AuthorService theAuthorService, TypeService theTypeService) {
        bookDAO = theBookDAO;
        authorService = theAuthorService;
        typeService = theTypeService;
    }

    @Override
    @Transactional
    public List<BookResponseDTO> findAll() {
        return bookDAO.findAll();
    }

    @Override
    @Transactional
    public BookResponseDTO findById(int theId) {

        Book theBook = bookDAO.findById(theId);

        BookResponseDTO theBookResponseDTO = new BookResponseDTO(theBook);


        return theBookResponseDTO;
    }

    @Override
    @Transactional
    public BookResponseDTO save(CreateBookRequestDTO createBookRequestDTO) {

        Book theBook = new Book(createBookRequestDTO.getName(), createBookRequestDTO.getPageNumber(),createBookRequestDTO.getStatus());

        List<Author> theAuthorList = authorService.findAll();
        int authorControl = 0;
        for (Author theAuthor: theAuthorList) {
            if(theAuthor.getName().equals(createBookRequestDTO.getAuthorName())){
                theBook.setAuthor(theAuthor);
                authorControl++;
            }
        }
        if(authorControl == 0){
            theBook.setAuthor(authorService.save(new Author(createBookRequestDTO.getAuthorName())));
        }

        List<Type> responseTypes = new ArrayList<>();
        List<Type> types = typeService.findAll();
        int typeControl = 0;
        for (String createDTOTypeNames : createBookRequestDTO.getTypeNames()) {
            for (Type type: types) {
                if(createDTOTypeNames.equals(type.getName())){
                    responseTypes.add(type);
                    typeControl++;
                    break;
                }
            }
            if(typeControl == 0){
                responseTypes.add(typeService.save(new Type(createDTOTypeNames)));
            }
            typeControl = 0;
        }
        theBook.setTypes(responseTypes);

        bookDAO.save(theBook);

        return new BookResponseDTO(theBook);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        bookDAO.deleteById(theId);
    }

    @Override
    @Transactional
    public BookResponseDTO updateBookStatusById(UpdateStatusDTO updateStatusDTO){
        Book book = bookDAO.findById(updateStatusDTO.getBookId());

        book.setStatus(updateStatusDTO.getStatus().ordinal());

        bookDAO.save(book);

        return new BookResponseDTO(book);
    }
}

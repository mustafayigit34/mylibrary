package com.musti.mylibrary.service;

import com.musti.mylibrary.dao.AuthorDAO;
import com.musti.mylibrary.entity.Author;
import com.musti.mylibrary.model.AuthorResponseDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{

    private AuthorDAO authorDAO;

    public AuthorServiceImpl(AuthorDAO theAuthorDAO) {
        authorDAO = theAuthorDAO;
    }

    @Override
    @Transactional
    public List<Author> findAll() {
        return authorDAO.findAll();
    }

    @Override
    @Transactional
    public Author findById(int theId) {
        return authorDAO.findById(theId);
    }

    @Override
    @Transactional
    public Author save(Author theAuthor) {
        return authorDAO.save(theAuthor);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        authorDAO.deleteById(theId);
    }

    public List<AuthorResponseDTO> findAllAuthorResponseDTO(){

        List<Author> allAuthors = authorDAO.findAll();

        List<AuthorResponseDTO> responseAuthorResponseDTO = new ArrayList<>();

        for (Author author: allAuthors) {
            responseAuthorResponseDTO.add(new AuthorResponseDTO(author));
        }

        return responseAuthorResponseDTO;
    }

    public AuthorResponseDTO findByIdAuthorResponseDTO(int authorId){

        Author author = authorDAO.findById(authorId);

        return new AuthorResponseDTO(author);
    }


}

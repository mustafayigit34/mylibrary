package com.musti.mylibrary.service;

import com.musti.mylibrary.entity.Type;
import com.musti.mylibrary.model.TypeResponseDTO;

import java.util.List;

public interface TypeService {

    public List<Type> findAll();

    public Type findById(int theId);

    public Type save(Type theType);

    //public void deleteById(int theId);

    List<TypeResponseDTO> findAllTypeResponseDTO();

    TypeResponseDTO findByIdTypeResponseDTO(int typeId);
}

package com.musti.mylibrary.service;

import com.musti.mylibrary.dao.TypeDAO;
import com.musti.mylibrary.entity.Type;
import com.musti.mylibrary.model.TypeResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService{


    private TypeDAO typeDAO;

    public TypeServiceImpl(TypeDAO theTypeDAO) {
        typeDAO = theTypeDAO;
    }

    @Override
    public List<Type> findAll() {
        return typeDAO.findAll();
    }

    @Override
    public Type findById(int theId) {
        return typeDAO.findById(theId);
    }

    @Override
    public Type save(Type theType) {
        return typeDAO.save(theType);
    }

    /*
    @Override
    public void deleteById(int theId) {
        typeDAO.deleteById(theId);
    }
    */

    public List<TypeResponseDTO> findAllTypeResponseDTO(){

        List<Type> allTypes = typeDAO.findAll();

        List<TypeResponseDTO> responseTypeResponseDTO = new ArrayList<>();

        for (Type type: allTypes) {
            responseTypeResponseDTO.add(new TypeResponseDTO(type));
        }

        return responseTypeResponseDTO;
    }

    public TypeResponseDTO findByIdTypeResponseDTO(int typeId){

        Type type = typeDAO.findById(typeId);

        return new TypeResponseDTO(type);
    }
}

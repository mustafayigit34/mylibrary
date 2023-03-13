package com.musti.mylibrary.controller;

import com.musti.mylibrary.entity.Author;
import com.musti.mylibrary.entity.Type;
import com.musti.mylibrary.model.CreateTypeRequestDTO;
import com.musti.mylibrary.model.TypeResponseDTO;
import com.musti.mylibrary.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class TypeController {

    private TypeService typeService;

    @Autowired
    public TypeController(TypeService theTypeService){
        typeService = theTypeService;
    }

    // return list of types
    @GetMapping("/types")
    public List<TypeResponseDTO> findAll(){

        return typeService.findAllTypeResponseDTO();
    }

    // get type by id
    @GetMapping("/types/{typeId}")
    public TypeResponseDTO findById(@PathVariable int typeId){

        TypeResponseDTO type = typeService.findByIdTypeResponseDTO(typeId);

        if(type == null){
            throw new RuntimeException("Type not found - " + typeId);
        }

        return type;
    }

    // add new type
    @PostMapping("/types")
    public Type save(@RequestBody CreateTypeRequestDTO createTypeRequestDTO){

        Type theType = new Type(createTypeRequestDTO.getName());

        typeService.save(theType);
        return typeService.save(theType);
    }

    /*
    //delete type by id
    @DeleteMapping("/types/{typeId}")
    public String deleteById(@PathVariable int typeId){

        typeService.deleteById(typeId);

        return "Deleted - " + Integer.toString(typeId);
    }*/
}

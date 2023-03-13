package com.musti.mylibrary.dao;

import com.musti.mylibrary.entity.Type;

import java.util.List;

public interface TypeDAO {

    public List<Type> findAll();

    public Type findById(int theId);

    public Type save(Type theType);

    //public void deleteById(int theId);
}

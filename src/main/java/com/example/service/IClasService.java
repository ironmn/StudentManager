package com.example.service;

import com.example.domain.Clas;
import com.github.pagehelper.PageInfo;

public interface IClasService {
    public PageInfo<Clas> getAll(int page,int size);
    public Clas getById(String clasno);
    public int insert(Clas c);
    public int update(Clas c);
    public int deleteByIds(String[] ids);
}

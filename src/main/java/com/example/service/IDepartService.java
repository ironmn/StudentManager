package com.example.service;

import com.example.domain.Depart;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IDepartService {
    public PageInfo<Depart> getAll(int page, int size);
    public Depart getById(String id);
    public int insert(Depart d);
    public int update(Depart d);
    public int deleteByIds(String[] ids);
}

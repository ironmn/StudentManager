package com.example.service.Impl;

import com.example.dao.IDepartDao;
import com.example.domain.Depart;
import com.example.service.IDepartService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartServiceImpl implements IDepartService {

    @Autowired
    private IDepartDao departDao;
    @Override
    public PageInfo<Depart> getAll(int page, int size) {
        PageHelper.startPage(page,size);
        return new PageInfo<>(departDao.getAll());
    }

    @Override
    public Depart getById(String id) {
        return departDao.getById(id);
    }

    @Override
    public int insert(Depart d) {
        return departDao.insert(d);
    }

    @Override
    public int update(Depart d) {
        return departDao.update(d);
    }

    @Override
    public int deleteByIds(String[] ids) {
        return departDao.deleteByIds(ids);
    }
}

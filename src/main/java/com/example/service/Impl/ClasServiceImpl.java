package com.example.service.Impl;

import com.example.dao.IClasDao;
import com.example.domain.Clas;
import com.example.service.IClasService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClasServiceImpl implements IClasService {
    @Autowired
    private IClasDao clasDao;
    @Override
    public PageInfo<Clas> getAll(int page, int size) {
        PageHelper.startPage(page,size);
        return new PageInfo<>(clasDao.getAll());
    }

    @Override
    public Clas getById(String clasno) {
        return clasDao.getById(clasno);
    }

    @Override
    public int insert(Clas c) {
        return clasDao.insert(c);
    }

    @Override
    public int update(Clas c) {
        return clasDao.update(c);
    }

    @Override
    public int deleteByIds(String[] ids) {
        return clasDao.deleteByIds(ids);
    }
}

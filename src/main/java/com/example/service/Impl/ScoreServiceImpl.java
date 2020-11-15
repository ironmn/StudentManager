package com.example.service.Impl;

import com.example.dao.IScoreDao;
import com.example.dao.IStudentDao;
import com.example.domain.Score;
import com.example.service.IScoreService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl implements IScoreService {
    @Autowired
    private IScoreDao scoreDao;
    @Override
    public PageInfo<Score> getAll(int page, int size) {
        PageHelper.startPage(page,size);
        return new PageInfo<>(scoreDao.getAll());
    }

    @Override
    public Score getById(Score s) {
        return scoreDao.getById(s);
    }

    @Override
    public int insert(Score s) {
        return scoreDao.insert(s);
    }

    @Override
    public int update(Score s) {
        return scoreDao.update(s);
    }

    @Override
    public int deleteById(Score s) {
        return scoreDao.deleteById(s);
    }
}

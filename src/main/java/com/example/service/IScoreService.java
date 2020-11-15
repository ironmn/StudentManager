package com.example.service;

import com.example.domain.Score;
import com.github.pagehelper.PageInfo;

public interface IScoreService {
    public PageInfo<Score> getAll(int page,int size);
    public Score getById(Score s);
    public int insert(Score s);
    public int update(Score s);
    public int deleteById(Score s);
}

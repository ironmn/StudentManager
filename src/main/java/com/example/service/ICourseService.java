package com.example.service;

import com.example.domain.Course;
import com.github.pagehelper.PageInfo;

public interface ICourseService{
    public PageInfo<Course> getAll(int page,int size);
    public Course getById(String cno);
    public int insert(Course c);
    public int update(Course c);
    public int deleteByIds(String[] ids);
}

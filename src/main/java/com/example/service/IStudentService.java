package com.example.service;

import com.example.domain.Student;
import com.github.pagehelper.PageInfo;


public interface IStudentService {
    public PageInfo<Student> getAll(int page,int size);
    public Student getById(String sno);
    public int insert(Student s);
    public int update(Student s);
    public int deleteByIds(String[] ids);
}

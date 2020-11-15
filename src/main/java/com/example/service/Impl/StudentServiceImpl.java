package com.example.service.Impl;

import com.example.dao.IStudentDao;
import com.example.domain.Student;
import com.example.service.IStudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentDao studentDao;
    @Override
    public PageInfo<Student> getAll(int page,int size) {
        PageHelper.startPage(page,size);
        List<Student> list = studentDao.getAll();
        return new PageInfo<>(list);
    }

    @Override
    public Student getById(String sno) {
        return studentDao.getById(sno);
    }

    @Override
    public int insert(Student s) {
        return studentDao.insert(s);
    }

    @Override
    public int update(Student s) {
        return studentDao.update(s);
    }

    @Override
    public int deleteByIds(String[] ids) {
        return studentDao.deleteByIds(ids);
    }
}

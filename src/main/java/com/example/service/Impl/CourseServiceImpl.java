package com.example.service.Impl;

import com.example.dao.ICourseDao;
import com.example.domain.Course;
import com.example.service.ICourseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements ICourseService {
    @Autowired
    private ICourseDao courseDao;
    @Override
    public PageInfo<Course> getAll(int page, int size) {
        PageHelper.startPage(page,size);
        return new PageInfo<>(courseDao.getAll());
    }

    @Override
    public Course getById(String cno) {
        return courseDao.getById(cno);
    }

    @Override
    public int insert(Course c) {
        return courseDao.insert(c);
    }

    @Override
    public int update(Course c) {
        return courseDao.update(c);
    }

    @Override
    public int deleteByIds(String[] ids) {
        return courseDao.deleteByIds(ids);
    }
}

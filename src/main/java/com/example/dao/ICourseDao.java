package com.example.dao;

import com.example.domain.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICourseDao {
    @Select("select * from course")
    public List<Course> getAll();

    @Select("select * from course where cno = #{cno}")
    public Course getById(String id);

    @Insert("insert into course(cno,cname,credit) " +
            "values(#{cno},#{cname},#{credit})")
    public int insert(Course c);

    @Update("update course  set cname=#{cname}," +
            "credit=#{credit} " +
            "where cno=#{cno}")
    public int update(Course c);

    @Delete("<script>" +
            "delete from course where cno in " +
            "<foreach item='id' collection='array' open='(' separator=',' close=')'>" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    public int deleteByIds(String[] ids);
}

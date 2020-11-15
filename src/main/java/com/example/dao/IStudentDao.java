package com.example.dao;

import com.example.domain.Clas;
import com.example.domain.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentDao {

    @Select("select * from student")
    @Results({
            @Result(id=true,property = "sno",column = "sno"),
            @Result(property = "clas",column = "clasno",javaType = Clas.class,
                    one=@One(select = "com.example.dao.IClasDao.getById"))
    })
    public List<Student> getAll();

    @Select("select * from student where sno = #{sno}")
    @Results({
            @Result(id=true,property = "sno",column = "sno"),
            @Result(property = "clas",column = "clasno",javaType = Clas.class,
                    one=@One(select = "com.example.dao.IClasDao.getById"))
    })
    public Student getById(String sno);

    @Insert("insert into student(sno,sname,clasno,phone,address) " +
            "value(#{sno},#{sname},#{clasno},#{phone},#{address})")
    public int insert(Student s);

    @Update("update student set " +
            "sname = #{sname}," +
            "clasno = #{clasno}," +
            "phone = #{phone}," +
            "address = #{address} " +
            "where sno = #{sno}")
    public int update(Student s);

    @Delete("<script>" +
            "delete from student where sno in " +
            "<foreach collection='array' item='id' open='(' separator=',' close=')'>" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    public int deleteByIds(String[] ids);
}

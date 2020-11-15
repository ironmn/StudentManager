package com.example.dao;

import com.example.domain.Clas;
import com.example.domain.Depart;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClasDao {
    @Select("select * from clas")
    @Results({
            @Result(id=true,property = "clasno",column = "clasno"),
            @Result(property = "departno",column = "departno"),
            @Result(property = "depart",column = "departno",javaType = Depart.class,
                    one=@One(select = "com.example.dao.IDepartDao.getById"))
    })
    public List<Clas> getAll();

    @Select("select * from clas where clasno = #{clasno}")

    @Results({
            @Result(id=true,property = "clasno",column = "clasno"),
            @Result(property = "departno",column = "departno"),
            @Result(property = "depart",column = "departno",javaType = Depart.class,
                    one=@One(select = "com.example.dao.IDepartDao.getById"))
    })
    public Clas getById(String id);

    @Insert("insert into clas(clasno,clasname,departno) " +
            "value(#{clasno},#{clasname},#{departno})")
    public int insert(Clas c);

    @Update("update clas set clasname=#{clasname}," +
            "departno=#{departno} " +
            "where clasno=#{clasno}")
    public int update(Clas c);

    @Delete("<script>" +
            "delete from clas where clasno in" +
            "<foreach collection='array' item='id' open='(' separator=',' close=')'>" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    public int deleteByIds(String[] ids);
}

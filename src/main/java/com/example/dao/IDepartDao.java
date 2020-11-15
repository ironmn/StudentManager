package com.example.dao;

import com.example.domain.Depart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDepartDao {
    @Select("select * from depart")
    public List<Depart> getAll();

    @Select("select * from depart where departno = #{departno}")
    public Depart getById(String id);

    @Insert("insert into depart(departno,departname) " +
            "value(#{departno},#{departname})")
    public int insert(Depart d);

    @Update("update depart set departname=#{departname} " +
            "where departno = #{departno}")
    public int update(Depart d);

    @Delete("<script>" +
            "delete * from depart where departno in" +
            "<foreach collection='array' item='id' open='(' separator=',' close=')'>" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    public int deleteByIds(String[] ids);
}

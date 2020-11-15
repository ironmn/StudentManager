package com.example.dao;

import com.example.domain.Score;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IScoreDao {

    @Select("select * from score")
    public List<Score> getAll();

    @Select("select * from score where sno=#{sno} and cno=#{cno}")
    public Score getById(Score s);

    @Insert("insert into score(sno,cno,score) " +
            "value(#{sno},#{cno},#{score})")
    public int insert(Score s);

    @Update("update score set score = #{score} " +
            "where sno = #{sno} " +
            "and cno = #{cno}")
    public int update(Score s);

    @Delete("delete from score where sno = #{sno} and cno = #{cno}")
    public int deleteById(Score s);
}

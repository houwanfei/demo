package com.example.demo.mappers;

import com.example.demo.entity.FilmTag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by houwanfei on 2017/7/27.
 */
public interface FilmTagMapper {
    @Select("select * from film_tags")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "tag", column = "tag"),
            @Result(property = "tagUrl", column = "tag_url"),
            @Result(property = "status", column = "status")
    })
    List<FilmTag> getAll();

    @Select("select * from film_tags where id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "tag", column = "tag"),
            @Result(property = "tagUrl", column = "tag_url"),
            @Result(property = "status", column = "status")
    })
    FilmTag getOne(Integer id);

}

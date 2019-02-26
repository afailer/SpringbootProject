package com.tjwq.demo.mapper;

import com.tjwq.demo.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Insert("INSERT INTO user(name,email,create_time,age) VALUES (#{name}, #{email},#{createTime},#{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(User user);

    @Select("SELECT * FROM user")
    @Results({
            @Result(column = "create_time", property = "createTime")
    })
    List<User> findAll();


    @Select("SELECT * from user WHERE id = #{id}")
    @Results({
            @Result(column = "create_time", property = "createTime")
    })
    User findById(Long id);


    @Update("UPDATE user SET name=#{name} WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id =#{userId}")
    void delete(Long userId);
}

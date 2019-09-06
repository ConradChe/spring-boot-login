package com.test.springbootlogin.mapper;

import com.test.springbootlogin.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where name=#{name}")
    public User find(String name);

    @Select("insert into user (name,password) values(#{name},#{password})")
    public void insert(User u);
}

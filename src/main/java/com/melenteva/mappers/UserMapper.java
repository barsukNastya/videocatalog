package com.melenteva.mappers;

import com.melenteva.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {

    @Select("SELECT USERNAME as userName, USERPASSWORD as userPassword FROM user WHERE (userName = #{userName} AND userPassword = #{userPassword})")
    public User getUserByNameAndPassword(@Param("userName")String userName, @Param("userPassword") String userPassword);

    @Results(value={
            @Result(javaType=User.class),
            @Result(property="id", column="ID"),
            @Result(property="userName", column="userName"),
            @Result(property="userPassword", column="userPassword"),
            @Result(property="isAdmin", column="isAdmin")
    })
    @Select("SELECT ID, userName, userPassword, isAdmin FROM user WHERE (userName = #{userName} AND userPassword = #{userPassword})")
    public User getUserByNameAndPasswordAndIsAdmin(@Param("userName")String userName, @Param("userPassword") String userPassword, @Param("isAdmin") Boolean isAdmin);




}

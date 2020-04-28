package com.cpf.community.dao;

import com.cpf.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    //查询用户信息
    User selectById(int id);
    User selectByUsername(String username);
    User selectByEmail(String email);

    //添加新的用户
    int insertUser(User user);

    //修改用户信息
    int updateStatus(int id, int status);
    int updateHeaderUrl(int id, String headerUrl);
    int updatePassword(int id, String password);



}

package com.edward.mt.mapper;

import com.edward.mt.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User login(User user);

    User checkData(@Param("type") int type, @Param("checkData") String checkData);

    int addUser(User user);

    int activeUser(int id);

    User getInfo(int id);

    int updateUser(User user);
}

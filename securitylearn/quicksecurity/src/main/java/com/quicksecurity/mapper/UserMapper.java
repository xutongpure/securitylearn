package com.quicksecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quicksecurity.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
//@Repository
public interface UserMapper extends BaseMapper<User> {
}
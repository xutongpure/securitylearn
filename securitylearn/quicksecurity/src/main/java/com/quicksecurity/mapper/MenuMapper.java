package com.quicksecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quicksecurity.domain.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author 三更  B站： https://space.bilibili.com/663528522
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    List<String> selectPermsByUserId(Long id);
}
package com.quicksecurity;

import com.quicksecurity.domain.User;
import com.quicksecurity.mapper.MenuMapper;
import com.quicksecurity.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import java.util.List;
import java.util.function.Consumer;

@SpringBootTest
public class MapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Test
    public void testBCryptPasswordEncoder() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode1 = passwordEncoder.encode("1234");
        String encode2 = passwordEncoder.encode("1234");
//        System.out.println(encode1);
//        System.out.println(encode2);
        boolean matches = passwordEncoder.matches("1234", "$2a$10$qV/F6/DWIDcxzdDvSJz3yuuFWjbWfRt.N5NjJT3D.jjJc9jRU.MXy");
        System.out.println(matches);
    }

    @Test
    public void testUserMapper() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }


    @Test
    public void testSelectPermsByUserId() {
        List<String> list = menuMapper.selectPermsByUserId(2L);
        list.forEach(System.out::println);
    }
}

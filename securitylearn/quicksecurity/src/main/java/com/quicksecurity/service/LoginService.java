package com.quicksecurity.service;

import com.quicksecurity.domain.ResponseResult;
import com.quicksecurity.domain.User;

public interface LoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}

package com.quicksecurity.controller;

import com.quicksecurity.domain.ResponseResult;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    @PreAuthorize("hasAnyAuthority('system:dept:list','admin')")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/testCors")
//    @PreAuthorize("@ex.hasAuthority('system:dept:list')")
    public ResponseResult testCors() {
        return new ResponseResult(200,"testCores");
    }
}

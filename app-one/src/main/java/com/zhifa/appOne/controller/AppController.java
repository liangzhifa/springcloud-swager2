package com.zhifa.appOne.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api(tags="应用1controller")
@RestController
@RequestMapping()
public class AppController {
    @GetMapping("/hello")
    @ApiOperation(value = "你好",  notes = "务必提交json格式")
    public String hello(HttpServletRequest request){

        return "one|hello";
    }
}

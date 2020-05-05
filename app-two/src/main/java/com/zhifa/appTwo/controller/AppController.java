package com.zhifa.appTwo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags ="应用2AppController" )
@RestController
@RequestMapping()
public class AppController {
    @GetMapping("/hi")
    @ApiOperation(value = "你好", notes = "务必提交json格式")
    public String hi(){

        return "two|hi";
    }
}

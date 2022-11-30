package com.mam.controller;

import com.mam.annotation.MyAnnotation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Anmin
 * @Date 2022/11/30
 **/
@RequestMapping("/path")
@RestController
public class MyController {

    //http://localhost:8082/path/annotation?str=AOP
    @MyAnnotation(value = "AOP test")
    @RequestMapping("/annotation")
    public String myAnnotation(@RequestParam("str") String str){
        return "Hello ".concat(str);
    }
}

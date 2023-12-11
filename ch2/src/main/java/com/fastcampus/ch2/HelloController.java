package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//1. 원격 프로그램으로 등록
//2. URL과 메서드를 연결
@RestController //1.원격 프로그램으로 등록
public class HelloController {  //원격프로그램
    @RequestMapping("/hello")
    public String main(String[] args) {
        System.out.println("Hello");
        return "Hello";
    }
}

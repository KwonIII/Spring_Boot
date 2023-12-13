package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1. 원격 프로그램으로 등록
//2. URL과 메서드를 연결
@Controller //1.원격 프로그램으로 등록
public class HomeController {  //원격프로그램
    @RequestMapping("/")
    public String main(String[] args) {

        return "index"; //templates/index.html
    }
}

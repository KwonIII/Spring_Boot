package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

//1. 원격 프로그램으로 등록
//2. URL과 메서드를 연결
@Controller //1.원격 프로그램으로 등록
public class HomeController {  //원격프로그램
    @RequestMapping("/")
    public String main() {

        return "index"; //templates/index.html
    }
    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("lastName","Kwon");
        model.addAttribute("firstName","Ilkeun");
        model.addAttribute("list", Arrays.asList("aaa","bbb","ccc","ddd","eee"));
        return "test"; //templates/test.html
    }
}

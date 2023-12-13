package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URLEncoder;

@Controller
@RequestMapping("/login")
public class LoginController {

//    @RequestMapping("/login/login")
//    @RequestMapping(value="/login/login", method=RequestMethod.GET)
    @GetMapping("/login")
    public String showLogin(){
        return "login"; //login.html
    }
//    하나의 메서드로 GET, POST를 둘 다 처리하는 경우
    //    @RequestMapping(value="/login/login",method = {RequestMethod.GET,RequestMethod.POST})
//    @RequestMapping(value="/login/login",method = RequestMethod.POST)
    @PostMapping("/login")
    public String login(String id, String pwd, Model model)throws Exception{
        //1. id,pwd 확인
        if(loginCheck(id,pwd)){
            //2. 일치하면, userInfo.html을 보여줌
            model.addAttribute("id",id);
            model.addAttribute("pwd",pwd);
        return "userInfo";  //userInfo.html
        }else{
            //3. 일치하지 않으면, login.html로 이동
            String msg = URLEncoder.encode( "id 또는 pwd가 일치하지 않습니다.","utf-8");
        return "redirect:/login/login?msg="+msg; //GET
        }
    }

    private boolean loginCheck(String id, String pwd) {
        return id.equals("asdf") && pwd.equals("1234");
    }

}

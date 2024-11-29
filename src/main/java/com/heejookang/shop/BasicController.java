package com.heejookang.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// annotation - 웹 서버의 역할
// controller를 붙이면 class 안에서 서버 제작이 가능함
// annotation을 붙이면 스프링에서 알아서 main에 추가해줌
@Controller

// controller는 항상 이름에 controller라고 적어줘야함
public class BasicController {

    // 서버 제작 가능
    // 누가 /main 으로 접속 했을 때
    // API
    @GetMapping("/main")
    // 문자 그대로 보내는게 responseBody
    @ResponseBody
    String main() {
        // return을 보내줌
        // html 을 보낸게 아니라 문자열을 보내줌

        String mainpage = "메인 페이지";
        return mainpage;


    }

    // /mypage로 접속 했을 떄
    // 마이페이지임을  보내주고 싶을 때
    @GetMapping("/mypage")
    @ResponseBody
    String mypage() {
        return "마이페이지임미댜";
    }
    // ctrl + alt + l = 자동 정렬
}

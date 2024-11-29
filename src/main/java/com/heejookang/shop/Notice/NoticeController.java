package com.heejookang.shop.Notice;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NoticeController {


    private final NoticeRepository noticeRepository;
    // 의존성 주입 생성자 주입(이전 방법)
    // @Autowired
    // public ItemController(ItemRepository itemRepository) {
    //     this.itemRepository = itemRepository;
    // }

    // 여기서 서버 제작 가능
    @GetMapping("/notice")
    @ResponseBody //Restful
    List<Notice> noticeList(Model model) {
        // 템플릿 엔진: 데이터베이스의 데이터를 html에 넣을 수 있는 거
        // HTML에 서버데이터 넣어서 보내주려면
        // 1. Model model 추가
        // 2. model.addAttribute(변수명 , 값 )
        // 3. th:text="${작명}
        // 데이터베이스
        List<Notice> notices = noticeRepository.findAll();
        return notices;
    }

    // restful api 오류 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handler(){
        return ResponseEntity.status(400).body("니잘못임");
    }
}

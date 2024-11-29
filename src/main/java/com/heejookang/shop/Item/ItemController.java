package com.heejookang.shop.Item;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {
    // 하나의 클래스에는 비슷한 기능을 하는 함수들을 모아놓자
    // solid 원칙 - 하나의 메서드에는 하나의 기능만 모아놓자
    private final ItemRepository itemRepository;
    private final ItemService itemService;
    // 의존성 주입 생성자 주입(이전 방법)
    // @Autowired
    // public ItemController(ItemRepository itemRepository) {
    //     this.itemRepository = itemRepository;
    // }

    // 여기서 서버 제작 가능
    @GetMapping("/list")
    String itemList(Model model) {
        // 템플릿 엔진: 데이터베이스의 데이터를 html에 넣을 수 있는 거
        // HTML에 서버데이터 넣어서 보내주려면
        // 1. Model model 추가
        // 2. model.addAttribute(변수명 , 값 )
        // 3. th:text="${작명}
        // 데이터베이스
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "list";
    }

    @GetMapping("/write")
    String write(Model model) {
        return "write";
    }

    // first input = 상품명
    // second input = 상품가격
    // button click = db insert

    // @PostMapping(value = "/add")

    @PostMapping("/add")
    // void addPost(@RequestParam(name="title") String title,@RequestParam(name="price") int price, @RequestParam(name="username")String username){
//    (@RequestParam Map formdata
    // @ModelAttribute 생략가능
    String addPost(@ModelAttribute Item item){
/*        System.out.println(formdata.get("title"));
        System.out.println(formdata.get("price"));*/
        // String title, int price, String username
        //@RequestParam Map formdata
        // System.out.println("/add 들어옴");
/*        System.out.println(title);
        System.out.println(price);
        System.out.println(username);*/
/*        Item item = new Item();
        item.setTitle(title);
        item.setPrice(price);
        item.setUsername(username);
        itemRepository.save(item);*/

        // 데이터 베이스 입출력 기능
        // html을 보내주는 기능
        return itemService.addPost(item);
    }

    @GetMapping("/detail/{itemId}")
    String detailItem(Model model, @PathVariable Long itemId) {
        Optional<Item> item = itemRepository.findById(itemId);
        if(item.isPresent()){
            model.addAttribute("item", item.get());
            return "detail";
        }else{
            return "redirect:/list";
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e) {
        return ResponseEntity.status(400).body("qkdHRWHL");
    }

    @GetMapping("/edit/{itemId}")
    String edit(Model model,@PathVariable Long itemId) {
        Optional<Item> item = itemRepository.findById(itemId);
        if(item.isPresent()){
            model.addAttribute("editItem", item.get());
            return "edit";
        }else{
            return "redirect:/list";
        }

    }

    // url 파라미터를 보여줄 필요 없음
    @PostMapping("/edit")
    String editItem(Item item) {
        // jpa 에서는 update가 없고 save를 사용함
        itemRepository.save(item);
        return "redirect:/list";
    }
}

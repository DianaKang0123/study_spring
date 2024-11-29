package com.heejookang.shop.Item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    // 의존성 주입의 장점
    // 객체를 여러번 뽑지 않아도 되서 효율적이다.
    // 클래스 간 커플링을 줄일 수 있다.
    private final ItemRepository itemRepository;

    String addPost(Item item){
        itemRepository.save(item);
        return "redirect:/list";
    }
}

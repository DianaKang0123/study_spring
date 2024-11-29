package com.heejookang.shop.Item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// Entity : class 이름으로 테이블 생성 annotation
@Entity
@Getter
@Setter
public class Item {
    // jpa 덕분에 가능
    @Id // 인덱스
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private Long id;
    private String title;
    private int price;
    private String username;

    // getter 와 setter 사용을 안하면 하나씩 이렇게 해줘야함
    // 위에 @data를 넣을 수 있다.
//    String getTitle() {
//        return title;
//    }
//    String getUsername() {
//        return username;
//    }
}


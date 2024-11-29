package com.heejookang.shop.Notice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Date updateddate;
    // Date 보다 localdatetime을 사용하는 것이 나음
        // date보다 LocalDateTime이 더 큰 개념 이므로 이걸 사용하는게 적합
}

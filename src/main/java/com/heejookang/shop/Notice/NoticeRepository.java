package com.heejookang.shop.Notice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// extends JpaRepository<Entity명, id컬럼타입>
public interface NoticeRepository extends JpaRepository<Notice, Long> {
}

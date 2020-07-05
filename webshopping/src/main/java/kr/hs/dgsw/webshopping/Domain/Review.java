package kr.hs.dgsw.webshopping.Domain;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Review {
    private Long id;
    private Long productId;
    private Long userId; // user id를 받아올 시 join을 해야함
    private String content;
    private LocalDateTime created;
    private LocalDateTime modified;
}
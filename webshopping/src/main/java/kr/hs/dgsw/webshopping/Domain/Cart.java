package kr.hs.dgsw.webshopping.Domain;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cart {
    private Long id;
    private String userId;
    private Long productId;
    private int price;
    private int amount;
    private int total;
    private LocalDateTime created;
}
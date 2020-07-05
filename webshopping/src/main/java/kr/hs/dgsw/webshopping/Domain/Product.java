package kr.hs.dgsw.webshopping.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {
    private Long id;
    private String name;
    private int price; // 단가
    private Long menuId;
    private Long submenuId;
    private String details; // 상세 설명
    private String factory; // 제조사
}
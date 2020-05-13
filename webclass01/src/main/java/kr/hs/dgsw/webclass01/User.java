package kr.hs.dgsw.webclass01;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String id; // ID
    private String name; // 이름
    private String email; // 이메일

    public String toString(){  // 유저 정보 String으로 반환해주는 함수
        return id + "/" + name + "/" + email; // ID, 이름, 이메일 '/'로 구분해서 반환 
    }

    public User(){ // 생성자
    }

    public User(String id, String name, String email){ // 생성자 오버로딩
        this.id = id;
        this.name = name;
        this.email = email;
    } // 입력받은 값으로 유저 값 세팅
}
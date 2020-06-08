package kr.hs.dgsw.weblog.Service;

import java.util.List;

import kr.hs.dgsw.weblog.Domain.User;

public interface UserService { // 인터페이스를 만들어 구현할 함수 나열

    User create(User user); // 유저 생성
    User read(Long id); // id에 맞는 유저 반환
    User update(Long id, User user); // id에 맞는 유저 정보 수정
    boolean delete(Long id); // id에 맞는 유저 삭제
    List<User> readAll(); // 모든 유저 반환
    
}
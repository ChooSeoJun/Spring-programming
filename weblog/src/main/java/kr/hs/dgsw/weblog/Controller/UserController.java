package kr.hs.dgsw.weblog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.hs.dgsw.weblog.Domain.User;
import kr.hs.dgsw.weblog.Protocol.ResponseFormat;
import kr.hs.dgsw.weblog.Protocol.ResponseType;
import kr.hs.dgsw.weblog.Service.UserService;

@RestController // 컨트롤러로 지정
public class UserController {
    @Autowired
    private UserService userService; // UserService 싱글톤 생성

    //모든 함수는 결과값이 NULL이라면 NULL 및 FAIL RETURN
    
    @PostMapping("/user/create")
    public ResponseFormat create(@RequestBody User user){ // 유저 생성 함수
        User newUser = userService.create(user);
        if(newUser != null){
            return new ResponseFormat(
                ResponseType.USER_ADD,
                newUser,
                newUser.getId()
            );
        } else {
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }

    @PutMapping("/user/update/{id}")
    public ResponseFormat update(@PathVariable Long id, @RequestBody User user){ // 유저의 primary키를 이용해 유저 정보 수정
        if(userService.update(id, user) != null){
            return new ResponseFormat(
                ResponseType.USER_UPDATE,
                userService.update(id, user),
                user.getId()
            );
        } else {
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }

    @DeleteMapping("/user/delete/{id}")
    public ResponseFormat delete(@PathVariable Long id) { // 유저의 primary키를 이용해 유저 삭제
        if(userService.delete(id)){
            return new ResponseFormat(
                ResponseType.USER_DELETE,
                userService.delete(id),
                id
            );
        } else {
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }

    @GetMapping("/user/read/{id}")
    public ResponseFormat read(@PathVariable Long id){ // 유저의 primary키를 이용해 해당 유저를 return
        if(userService.read(id) != null){
            return new ResponseFormat(
                ResponseType.USER_GET,
                userService.read(id),
                id
            );

        } else {
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }

    @GetMapping("/user/read")
    public ResponseFormat readAll(){ // 모든 유저를 List형식으로 return
        if(userService.readAll() != null){
            return new ResponseFormat(
                ResponseType.USER_GET_ALL,
                userService.readAll()
            );
        } else {
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }
}
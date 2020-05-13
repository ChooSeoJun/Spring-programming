package kr.hs.dgsw.webclass01;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService; // 객체 선언

    @GetMapping("/user")
    @ResponseBody
    public List<User> list(){
        return userService.list(); // 모든 유저를 반환
    }
    @GetMapping("/user/{id}")
    @ResponseBody
    public User view(@PathVariable String id){
        return userService.view(id); // 해당하는 id의 유저를 반환
    }
    @PostMapping("/user")
    @ResponseBody
    public boolean add(@RequestBody User user){
        return userService.add(user); // 유저를 추가함
    }
    @PutMapping("/user")
    @ResponseBody
    public User update(@RequestBody User user){
        return userService.update(user); // 유저 정보 업데이트
    }
    @DeleteMapping("/user/{id}")
    @ResponseBody
    public boolean delete(@PathVariable String id){
        return userService.delete(id); // 해당 id를 가진 유저 삭제
    }
}
// CRUD Create  Read    Update  Delete
// SQL  insert  select  update  delete
// HTTP POST    GET     PUT     DELETE

package kr.hs.dgsw.weblog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.hs.dgsw.weblog.Domain.Post;
import kr.hs.dgsw.weblog.Protocol.ResponseFormat;
import kr.hs.dgsw.weblog.Protocol.ResponseType;
import kr.hs.dgsw.weblog.Service.PostService;

@RestController // 컨트롤러로 지정
public class PostController {
    @Autowired
    private PostService postService; // PostService 싱글톤 생성

    //모든 함수는 결과값이 NULL이라면 NULL 및 FAIL RETURN

    @PostMapping("/post/create") // POST 방식 매핑
    public ResponseFormat create(@RequestBody Post post){ // 게시물 생성 함수
        Post newPost = postService.create(post); // post가 생성됐는지 확인을 위해 newPost제작
        if(newPost != null){ // post null check
            return new ResponseFormat(
                ResponseType.POST_ADD, // 성공시 출력할 Response
                newPost,
                newPost.getId()
            );
        } else {
            return new ResponseFormat(
                ResponseType.FAIL, // 실패시 출력할 Response
                null
            );
        }
    }

    @PutMapping("/post/update/{id}") // PUT 방식 매핑, 게시물 id를 받아서 해당 게시물 수정
    public ResponseFormat update(@PathVariable Long id, @RequestBody Post post){ // 게시물 내용 수정 함수
        if(postService.update(id, post) != null){
            return new ResponseFormat(
                ResponseType.POST_UPDATE,
                postService.update(id, post), // 실제 함수 실행
                post.getId()
            );
        } else {
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }

    @DeleteMapping("/post/delete/{id}") // DELETE 방식 매핑, 게시물 id를 받아서 해당 게시물 삭제
    public ResponseFormat delete(@PathVariable Long id) { // 게시물 삭제 함수
        if(postService.delete(id)){
            return new ResponseFormat(
                ResponseType.POST_DELETE,
                postService.delete(id),
                id
            );
        } else {
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }

    @GetMapping("/post/read/{id}") // GET 방식 매핑, 게시물 id를 받아서 해당 id를 가진 post 반환
    public ResponseFormat read(@PathVariable Long id){
        if(postService.read(id) != null){
            return new ResponseFormat(
                ResponseType.POST_GET,
                postService.read(id),
                id
            );

        } else {
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }

    @GetMapping("/post/read/user/{userId}") // 유저 id(primary key)를 받아서 해당 유저가 쓴 게시물 중 정렬 방식(Desc)에 따라 Top에 해당하는 것을 반환
    public ResponseFormat readByUserId(@PathVariable Long userId){
        if(postService.readByUserId(userId) != null){
            return new ResponseFormat(
                ResponseType.POST_GET_BY_USER,
                postService.readByUserId(userId),
                userId
            );
        } else {
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }

    @GetMapping("/post/read") // 전체 게시물을 List로 반환하는 함수
    public ResponseFormat readAll(){
        if(postService.readAll() != null){
            return new ResponseFormat(
                ResponseType.POST_GET_ALL,
                postService.readAll()
            );
        } else {
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }
}
package kr.hs.dgsw.weblog.Service;

import java.util.List;

import kr.hs.dgsw.weblog.Domain.Post;

public interface PostService {
    Post create(Post post); // 게시물 생성
    Post read(Long id); // id에 맞는 게시물 반환
    Post readByUserId(Long userId); // 유저 id에 맞는 게시물 반환
    Post update(Long id, Post post); // id에 맞는 게시물 반환
    boolean delete(Long id); // id에 맞는 게시물 삭제
    List<Post> readAll(); // 모든 게시물 반환
}
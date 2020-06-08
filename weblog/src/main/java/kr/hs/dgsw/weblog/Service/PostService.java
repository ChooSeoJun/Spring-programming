package kr.hs.dgsw.weblog.Service;

import java.util.List;

import kr.hs.dgsw.weblog.Domain.Post;

public interface PostService {
    Post create(Post post);
    Post read(Long id);
    Post readByUserId(Long userId);
    Post update(Long id, Post post);
    boolean delete(Long id);
    List<Post> readAll();
}
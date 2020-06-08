package kr.hs.dgsw.weblog.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.hs.dgsw.weblog.Domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Long>{
    Optional<Post> findTopByUserIdOrderByIdDesc(Long userId); // find = select * , from = Post, Where userId = userId, top = 하나만 보겠다, OrderById = 정렬은 postId로 한다, DESC = 내림차순 
}
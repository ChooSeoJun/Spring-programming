package kr.hs.dgsw.weblog.Service;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.hs.dgsw.weblog.Domain.Post;
import kr.hs.dgsw.weblog.Domain.User;
import kr.hs.dgsw.weblog.Repository.PostRepository;
import kr.hs.dgsw.weblog.Repository.UserRepository;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct // 초기화 진행 메서드
    private void init(){ // 클래스 인스턴스화 진행 시 실행(?), 생성자 역할
        User user = userRepository.save(new User("chuseojun","1234","추서준11","chuseojun@naver.com","010-1234-5678","chrome-search://ntpicon/?size=24%401x&url=https%3A%2F%2Fwww.facebook.com%2F"));
        postRepository.save(new Post(user.getId(),"안녕하세요.","첫 게시물입니다."));
    }

	@Override
	public Post create(Post post) { // 게시물 생성
        return postRepository.save(post);
    }

    @Override
	public Post read(Long id) { // primary키에 해당하는 게시물 return
        return postRepository.findById(id).isPresent() ? postRepository.findById(id).get() : null;
    }

	@Override
	public Post readByUserId(Long userId) { // 전달받은 유저의 primary키를 가진 Post의 제일 윗 게시물을 불러옴
        return postRepository
        .findTopByUserIdOrderByIdDesc(userId)
        .orElse(null);
    }
    
    @Override
	public Post update(Long id, Post post) { // primary키에 해당하는 게시물을 전달된 Post 정보로 업데이트
        return postRepository.findById(id)
                .map(found->{
                    found.setTitle(Optional.ofNullable(post.getTitle()).orElse(found.getTitle()));
                    found.setContent(Optional.ofNullable(post.getContent()).orElse(found.getContent()));
                    found.setPictures(Optional.ofNullable(post.getPictures()).orElse(found.getPictures()));
                    return postRepository.save(found); // 저장
                })
                .orElse(null);
	}

    @Override
	public boolean delete(Long id) { // primary키에 해당하는 게시물을 삭제하는 함수
		try{ 
            postRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

	@Override
	public List<Post> readAll() { // 모든 게시물을 list형식으로 반환
		
		return postRepository.findAll();
	}
    
}
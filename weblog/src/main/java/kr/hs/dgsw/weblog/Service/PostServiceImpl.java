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

    @PostConstruct
    private void init(){
        User user = userRepository.save(new User("chuseojun","1234","추서준11","chuseojun@naver.com","010-1234-5678",""));
        postRepository.save(new Post(user.getId(),"안녕하세요.","첫 게시물입니다."));
    }

	@Override
	public Post create(Post post) {
        return postRepository.save(post);
    }

    @Override
	public Post read(Long id) {
        return postRepository.findById(id).isPresent() ? postRepository.findById(id).get() : null;
    }

	@Override
	public Post readByUserId(Long userId) {
        return postRepository
        .findTopByUserIdOrderByIdDesc(userId)
        .orElse(null);
    }
    
    @Override
	public Post update(Long id, Post post) {
        return postRepository.findById(id)
                .map(found->{
                    found.setTitle(Optional.ofNullable(post.getTitle()).orElse(found.getTitle()));
                    found.setContent(Optional.ofNullable(post.getContent()).orElse(found.getContent()));
                    found.setPictures(Optional.ofNullable(post.getPictures()).orElse(found.getPictures()));
                    return postRepository.save(found);
                })
                .orElse(null);
	}

    @Override
	public boolean delete(Long id) {
		try{
            postRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

	@Override
	public List<Post> readAll() {
		
		return postRepository.findAll();
	}
    
}
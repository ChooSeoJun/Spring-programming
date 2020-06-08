package kr.hs.dgsw.weblog.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.hs.dgsw.weblog.Domain.User;
import kr.hs.dgsw.weblog.Repository.UserRepository;

@Service // 해당 클래스를 Service로 지정
public class UserServiceImpl implements UserService{ // 인터페이스 내 함수 기능 구현
    
    @Autowired
    private UserRepository userRepository; // UserRepository 싱글톤으로 생성

    @Override
    public User create(User user){ // 유저를 생성하는 함수
        Optional<User> found = userRepository.findByAccount(user.getAccount()); // 유저 리포지토리에서 들어온 유저의 계정으로 유저 검색 후 found에 저장
        if(found.isPresent()) return null; // 이미 유저가 존재한다면 null return
        return userRepository.save(user); // 아니라면 리포지토리에 저장
    }
    
    @Override
    public User update(Long id, User user){ // 유저의 정보를 수정하는 함수
        return userRepository.findById(id) // 리포지토리에서 primary키로 유저 검색, 들어온 값으로 리포지토리에 set
                .map(found ->{ // update가 되는 애들만 적어주기, id는 업데이트 불가 + auto generate이므로
                    // found.setPassword(Optional.ofNullable(user.getPassword()).orElse(found.getPassword()));
                    found.setName(Optional.ofNullable(user.getName()).orElse(found.getName()));
                    found.setEmail(Optional.ofNullable(user.getEmail()).orElse(found.getEmail()));
                    found.setPhone(Optional.ofNullable(user.getPhone()).orElse(found.getPhone()));
                    found.setProfilePath(Optional.ofNullable(user.getProfilePath()).orElse(found.getProfilePath()));
                    return userRepository.save(found);
                })
                .orElse(null);
    }

    @Override
	public boolean delete(Long id) { // primary키에 해당하는 유저를 삭제하는 함수
		
		try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
	}

	@Override
	public User read(Long id) { // primary키에 해당하는 유저를 삭제하는 함수
        Optional<User> user = userRepository.findById(id);
        return user.isPresent() ? user.get() : null; // 유저가 있다면 반환, 없다면 null return
    }

	@Override
	public List<User> readAll() { // 모든 유저를 list형식으로 반환
		return userRepository.findAll();
	}
}
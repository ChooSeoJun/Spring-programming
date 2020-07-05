package kr.hs.dgsw.webshopping.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.hs.dgsw.webshopping.Domain.User;
import kr.hs.dgsw.webshopping.Domain.UserMapper;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

	@Override
	public List<User> findAll() {
		
		return userMapper.findAll();
	}

	@Override
	public User findById(Long id) {
		return userMapper.findById(id);
	}

	@Override
	public User findByAccount(String account) {
        return userMapper.findByAccount(account);
	}

	@Override
	public int deleteById(Long id) {
		return userMapper.deleteById(id);
	}

	@Override
	public Long add(User user) {
		return userMapper.add(user);
	}

	@Override
	public int modify(User user) {
		return userMapper.modify(user);
	}

	@Override
	public User login(User user) {
		return userMapper.login(user);
	}
}
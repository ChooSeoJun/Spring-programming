package kr.hs.dgsw.webclass01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    List<User> userList; // 리스트 선언
    public UserServiceImpl(){
        userList = new ArrayList<>(); // 리스트 할당
        userList.add(new User("user1","추서준","chuseojun@dgsw.hs.kr")); // 유저 1 추가
        userList.add(new User("user2","추파춥스","candy@dgsw.hs.kr")); // 유저 2 추가
        userList.add(new User("user3","추러스","chewwrs@dgsw.hs.kr")); // 유저 3 추가
    }

	@Override
	public List<User> list() {
		return userList; // 유저 리스트 반환
	}

	@Override
	public User view(String id) { // Java 8+
        User user = userList.stream() // 유저 리스트에서
                .filter(found->found.getId().equals(id)) // 해당되는 id를 가진 유저 중
                .findAny() // 먼저 찾은 것 반환
                .orElse(null); // 없으면 null 반환
		return user; // user 반환
	}

	@Override
	public boolean add(User user) {
        User found = view(user.getId()); // 해당 id를 가진 유저 검색
        if(found == null) // found가 null일 경우 해당 id를 가진 유저가 없으므로 
            return userList.add(user); // user 추가
		return false; // 있으면 false 반환
	}

	@Override
	public User update(User user) {
        User found = view(user.getId()); // 해당 id를 가진 유저 검색
        if(found != null){ // found가 null이 아닐 경우 해당 id를 가진 유저가 있으므로
            found.setName(user.getName()); // 이름 업데이트
            found.setEmail(user.getEmail()); // 이메일 업데이트
        }
		return found; // 업데이트 된 user 반환 
	}

	@Override
	public boolean delete(String id) {
        User found = view(id); // 해당 id를 가진 유저 검색
        return userList.remove(found); // 해당 유저 삭제 후 반환
    }
    
    public User find1(String name){
        for(int i=0;i<userList.size();i++){  // for문을 이용해 유저 검색
            User user = userList.get(i);
            if(user.getName().equals(name)) return user; // 있을 경우 user 반환
        }
        return null;
    }
    public User find2(String name){
        Iterator<User> iterator = userList.iterator(); // 반복자 생성
        while(iterator.hasNext()){ // 반복자를 이용한 유저 검색, 요소가 남지 않을 때까지 반복
            User user = iterator.next(); // 유저 객체에 유저 정보 넣기
            if(user.getName().equals(name)) return user; // 있을 경우 user 반환
        }
        return null;
    }
    public User find3(String name){ // Java 5+
        for(User user : userList){ // foreach를 이용한 유저 검색
            if(user.getName().equals(name)) return user; // 있을 경우 user 반환
        }
        return null;
    }   
}
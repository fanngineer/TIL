package com.ssafy.ws.step5.manager;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.ws.step5.dto.User;

public class UserManager {
	// 코드를 작성하세요.
	// 싱글턴
	// 유일한 인스턴스를 static으로 생성
	private static UserManager instance = new UserManager();
	private List<User> users;
	private int userSeq; // auto increment 기능을 dummy로 구현
	// 외부에서 생성하지 못하도록 생성자를 private

	private UserManager() {
		User user = new User(userSeq++, "a", "a", "a", "a", "a");
		users = new ArrayList<>();
		users.add(user);
		
	}

	// 외부에서 인스턴스에 접근할 수 있도록 getter 함수
	// 클래스 이름으로 바로 접근 가능해야하므로 static으로 만들어줘야한다.
	public static UserManager getInstance() {
		return instance;
	}

	// 리스트에 유저를 추가(signup에 활용)
	public void addUser(User user) {
		user.setUserSeq(userSeq++);
		users.add(user);
	}

	// 리스트에서 특정 유저(id,password)가져오기
	public User getUser(String userId, String password) {
		for (int i = 0; i < users.size(); i++) {
			User temp = users.get(i);
			if (temp.getUserId().equals(userId) && temp.getPassword().equals(password))
				return temp;
		}
		return null;
	}
}

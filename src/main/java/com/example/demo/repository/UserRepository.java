package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public class UserRepository {

	
	@Autowired
	JdbcTemplate template;
	
	public List<String> getAllUserNames() {
		// TODO Auto-generated method stub
		List<String> userNameList = new ArrayList<>();
		userNameList.addAll(template.queryForList("select name from user", String.class));
		return userNameList;
	}

	public Object getAllUsers() {
		List<Object> userList = new ArrayList<>();
		userList.addAll(template.queryForList("select * from user"));
		return userList;
	}
	
	public void addUser(User u) {
		template.update("insert into user values (? ,?)",u.getId(),u.getName());
	}

	public void update(int id, String name) {
		
		template.update("update user set name = ? where id = ?",name, id);
		
		
	}
	
	public void deleteUser(int id) {
		template.update("delete from user where id = ?", id);
	}
	
}

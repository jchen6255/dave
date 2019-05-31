package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping(path="/user")
public class UserController {

	@Autowired
	UserRepository rep;
	

	@GetMapping("/adduser")
	public ModelAndView edit() {
		ModelAndView mv = new ModelAndView("edit");
		return mv;
	}
	
	
	@GetMapping("/names")
	public List<String> getAllUserNames(){
		return rep.getAllUserNames();
	}
	
	
	@GetMapping("/getusers")
	public ModelAndView getUsers(ModelAndView mv) {
		
		mv.addObject("user", rep.getAllUsers());
		mv.setViewName("showUser");
		return mv;
	}
	
	
	@PostMapping("/adduser")
	public String addUser(@RequestBody User u) {
		rep.addUser(u);
		return u.getName() + " is added to the DB";
	}
	
	@PutMapping("/updateuser")
	public String update(@RequestParam int id, @RequestParam String name) {
		rep.update(id, name);
		return "User with id : " + id + " is updated";
	}
	
	@DeleteMapping("/deleteuser")
	public String delete(@RequestParam int id) {
		rep.deleteUser(id);
		return "User with id : " + id + " is deleted";
	}
}

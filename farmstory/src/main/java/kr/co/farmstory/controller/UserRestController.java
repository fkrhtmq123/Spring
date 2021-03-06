package kr.co.farmstory.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.co.farmstory.service.UserService;

// @ResponseBody + @Controller 를 합친 문자열과 JSON을 출력하는 Controller
@RestController 
public class UserRestController {
	
	@Inject
	private UserService service;
	
	@GetMapping("/user/checkUid")
	public String checkUid(String uid) {
		
		int result = service.selectUserCount(uid);
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		return new Gson().toJson(json);
		//return "/user/register";
	}
	
	@GetMapping("/user/checkNick")
	public String checkNick(String nick) {
		
		return null;
	}
	
	@GetMapping("/user/checkEmail")
	public String checkEmail(String email) {
		
		return null;
	}

}

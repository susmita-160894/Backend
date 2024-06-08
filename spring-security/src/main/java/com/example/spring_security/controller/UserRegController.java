package com.example.spring_security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_security.dto.LoginDto;
import com.example.spring_security.dto.LoginMessageDto;
import com.example.spring_security.dto.UpdateUserDto;
import com.example.spring_security.dto.UserRegDto;
import com.example.spring_security.service.UserRegService;

@RestController
@RequestMapping("/api/users")
public class UserRegController {

	@Autowired
	private UserRegService userRegService;

	@PostMapping("/signup")
	public ResponseEntity<String> saveUserInfo(@RequestBody UserRegDto userRegDto) {
		return this.userRegService.SaveUserInfo(userRegDto);

	}

	@PostMapping("/login")
	public LoginMessageDto loginUser(@RequestBody LoginDto loginDto) {
		return this.userRegService.loginUser(loginDto);

	}

	@PostMapping("/update")
	public ResponseEntity<String> updateUser (@RequestBody UpdateUserDto updateUserDto, @RequestHeader String email ,
			 @RequestHeader String password) {
		return this.userRegService.updateUser(updateUserDto,email, password);
		
	}

	@GetMapping("/coins")
	public ResponseEntity<String> getThirdPartyResponse ( @RequestHeader(value= "X-CMC_PRO_API_KEY") String key ){
		return this.userRegService.getThirdPartyResponse(key);
		
	}
	


}

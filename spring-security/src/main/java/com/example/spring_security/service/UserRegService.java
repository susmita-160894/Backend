package com.example.spring_security.service;

import org.springframework.http.ResponseEntity;

import com.example.spring_security.dto.LoginDto;
import com.example.spring_security.dto.LoginMessageDto;
import com.example.spring_security.dto.UpdateUserDto;
import com.example.spring_security.dto.UserRegDto;

public interface UserRegService {

	public ResponseEntity<String> SaveUserInfo(UserRegDto userRegDto);

	public LoginMessageDto loginUser(LoginDto loginDto);


	public ResponseEntity<String> updateUser(UpdateUserDto updateUserDto, String email, String password);

	public ResponseEntity<String> getThirdPartyResponse(String key);

}

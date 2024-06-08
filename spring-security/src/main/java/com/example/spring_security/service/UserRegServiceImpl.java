package com.example.spring_security.service;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.spring_security.dto.LoginDto;
import com.example.spring_security.dto.LoginMessageDto;
import com.example.spring_security.dto.UpdateUserDto;
import com.example.spring_security.dto.UserRegDto;
import com.example.spring_security.entity.UserRegTable;
import com.example.spring_security.repository.UserRegRepository;


@Service
public class UserRegServiceImpl implements UserRegService {

	@Autowired
	private UserRegRepository userInfoRepository;

	@Autowired
	private PasswordEncoder passwordencoder;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public ResponseEntity<String> SaveUserInfo(UserRegDto userRegDto) {
		UserRegTable userRegTable = new UserRegTable(userRegDto.getId(), userRegDto.getEmail(),
				userRegDto.getFirstName(), userRegDto.getLastName(), userRegDto.getMobileNo(), userRegDto.getUsername(),
				this.passwordencoder.encode(userRegDto.getPassword()));
		userInfoRepository.save(userRegTable);
		return ResponseEntity.ok("User Saved Successfully");
	}

	@Override
	public LoginMessageDto loginUser(LoginDto loginDto) {
		UserRegTable user1 = userInfoRepository.findByEmail(loginDto.getEmail());
		if (user1 != null) {
			String password = loginDto.getPassword();
			String encodedPassword = user1.getPassword();
			Boolean isPasswordCorrect = passwordencoder.matches(password, encodedPassword);
			if (isPasswordCorrect) {
				Optional<UserRegTable> user = userInfoRepository.findOneByEmailAndPassword(password, encodedPassword);
				if (user.isPresent()) {
					return new LoginMessageDto("Login message", true);
				} else {
					return new LoginMessageDto("Login failed", false);
				}

			} else {
				return new LoginMessageDto("password not matched", false);
			}
		} else {
			return new LoginMessageDto("user not present", false);
		}

	}

	@Override
	public ResponseEntity<String> updateUser(UpdateUserDto updateUserDto,String email,String password) {
		LoginDto loginDto = new LoginDto();
		loginDto.setEmail(email);
		loginDto.setPassword(password);
		LoginMessageDto loginMessageDto=this.loginUser(loginDto);
		if (loginMessageDto.getStatus()) {
			String updatesFirstName = updateUserDto.getFirstName();
			String updatesLastName = updateUserDto.getLastName();
			String updatedMobileNo = updateUserDto.getMobileNo();
			String updatesPassword = updateUserDto.getPassword();
			
			userInfoRepository.updateUser(updatesFirstName,updatesLastName,updatedMobileNo,updatesPassword,email,password);
			return ResponseEntity.ok("user Updated successfully");
		}
		else {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST );
		}
		
	}

	@Override
	public ResponseEntity<String> getThirdPartyResponse(String key) {
		URI url = URI.create("https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest");
		HttpHeaders headers= new HttpHeaders();
		headers.add("X-CMC_PRO_API_KEY","27ab17d1-215f-49e5-9ca4-afd48810c149");
		HttpEntity<String> httpEntity = new HttpEntity<>(headers);
		ResponseEntity<String> response=this. restTemplate.exchange(url, HttpMethod.GET, httpEntity,String.class);
		return response;
	}


}

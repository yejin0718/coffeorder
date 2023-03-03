package com.coffeorder.kakaoserver.users.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coffeorder.kakaoserver.users.dto.LoginRequestDto;
import com.coffeorder.kakaoserver.users.dto.SignupRequestDto;
import com.coffeorder.kakaoserver.users.service.UsersService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/users")
@Controller
public class UserController {

	private final UsersService userService;


	@PostMapping("/signup")
	public String signup(@RequestBody SignupRequestDto signupRequestDto) {
		userService.signup(signupRequestDto);
		return "success";
	}

	@ResponseBody
	@PostMapping("/login")
	public String login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
		userService.login(loginRequestDto, response);
		return "success";
	}

}


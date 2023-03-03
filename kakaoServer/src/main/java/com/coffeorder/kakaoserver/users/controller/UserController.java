package com.coffeorder.kakaoserver.users.controller;

import static com.coffeorder.kakaoserver.common.response.ResponseMessage.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.coffeorder.kakaoserver.common.response.Response;
import com.coffeorder.kakaoserver.users.dto.LoginRequestDto;
import com.coffeorder.kakaoserver.users.dto.SignupRequestDto;
import com.coffeorder.kakaoserver.users.service.UsersService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/users")
@RestController
public class UserController {

	private final UsersService userService;


	@PostMapping("/signup")
	public Response signup(@RequestBody SignupRequestDto signupRequestDto) {
		userService.signup(signupRequestDto);
		return new Response(CREATE_USER_SUCCESS_MSG);
	}

	@ResponseBody
	@PostMapping("/login")
	public Response login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
		userService.login(loginRequestDto, response);
		return new Response(LOGIN_USER_SUCCESS_MSG);
	}

}


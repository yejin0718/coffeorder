package com.coffeorder.kakaoserver.users.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coffeorder.kakaoserver.users.dto.LoginRequestDto;
import com.coffeorder.kakaoserver.users.dto.SignupRequestDto;
import com.coffeorder.kakaoserver.users.entity.Users;
import com.coffeorder.kakaoserver.jwt.JwtUtil;
import com.coffeorder.kakaoserver.users.repository.UsersRepository;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsersService {

	private final UsersRepository usersRepository;
	private final JwtUtil jwtUtil;
	private static final String ADMIN_TOKEN = "AAABnvxRVklrnYxKZ0aHgTBcXukeZygoC";

	@Transactional
	public void signup(SignupRequestDto signupRequestDto) {
		String email = signupRequestDto.getEmail();
		String password = signupRequestDto.getPassword();

		// 회원 중복 확인
		Optional<Users> found = usersRepository.findByEmail(email);
		if (found.isPresent()) {
			throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
		}

		Users user = new Users(email, password);
		usersRepository.save(user);
	}

	@Transactional
	public void login(LoginRequestDto loginRequestDto, HttpServletResponse response) {
		String email = loginRequestDto.getEmail();
		String password = loginRequestDto.getPassword();

		// 사용자 확인
		Users users = usersRepository.findByEmail(email).orElseThrow(
			() -> new IllegalArgumentException("등록된 사용자가 없습니다.")
		);
		// 비밀번호 확인
		if(!users.getPassword().equals(password)){
			throw  new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
		}

		response.addHeader(JwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(users.getEmail()));
	}

}


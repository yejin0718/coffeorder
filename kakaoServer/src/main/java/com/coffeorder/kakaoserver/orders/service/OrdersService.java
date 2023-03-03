package com.coffeorder.kakaoserver.orders.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coffeorder.kakaoserver.jwt.JwtUtil;
import com.coffeorder.kakaoserver.orders.dto.RequestCharge;
import com.coffeorder.kakaoserver.orders.repository.OrderRepository;
import com.coffeorder.kakaoserver.users.entity.Users;
import com.coffeorder.kakaoserver.users.repository.UsersRepository;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrdersService {

	private final OrderRepository orderRepository;
	private final UsersRepository usersRepository;
	private final JwtUtil jwtUtil;

	@Transactional
	public Long charge(RequestCharge requestCharge, HttpServletRequest request) {

		Long point = requestCharge.getPoint();

		String token = jwtUtil.resolveToken(request);
		Claims claims = null;

		if (token != null) {
			if (jwtUtil.validateToken(token)) {
				claims = jwtUtil.getUserInfoFromToken(token);
			} else {
				throw new IllegalArgumentException("Token Error");
			}
		}

		Users users = usersRepository.findByEmail(claims.getSubject()).orElseThrow(
			() -> new IllegalArgumentException("계정 오류")
		);

		users.update(point);

		return users.getPoint();
	}


}

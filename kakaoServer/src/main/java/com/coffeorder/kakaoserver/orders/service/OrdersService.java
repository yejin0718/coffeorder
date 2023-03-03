package com.coffeorder.kakaoserver.orders.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coffeorder.kakaoserver.jwt.JwtUtil;
import com.coffeorder.kakaoserver.menu.entity.Menu;
import com.coffeorder.kakaoserver.menu.repository.MenuRepository;
import com.coffeorder.kakaoserver.orders.dto.RequestCharge;
import com.coffeorder.kakaoserver.orders.dto.RequestOrder;
import com.coffeorder.kakaoserver.orders.entity.Orders;
import com.coffeorder.kakaoserver.orders.repository.OrdersRepository;
import com.coffeorder.kakaoserver.users.entity.Users;
import com.coffeorder.kakaoserver.users.repository.UsersRepository;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrdersService {

	private final OrdersRepository ordersRepository;
	private final UsersRepository usersRepository;
	private final MenuRepository menuRepository;
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

	@Transactional
	public Long order(RequestOrder requestOrder, HttpServletRequest request) {

		String name = requestOrder.getName();

		Menu menu = menuRepository.findByName(name).orElseThrow(
			() -> new IllegalArgumentException("존재하지 않는 메뉴입니다")
		);

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

		Orders orders = new Orders(users, menu);
		ordersRepository.save(orders);

		if(users.getPoint() < menu.getPrice()){
			throw new IllegalArgumentException("잔액부족");
		}
		users.pay(menu.getPrice());

		return users.getPoint();

	}


}

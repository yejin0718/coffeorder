package com.coffeorder.kakaoserver.orders.controller;

import static com.coffeorder.kakaoserver.common.response.ResponseMessage.*;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffeorder.kakaoserver.common.response.DataResponse;
import com.coffeorder.kakaoserver.menu.entity.Menu;
import com.coffeorder.kakaoserver.orders.dto.RequestCharge;
import com.coffeorder.kakaoserver.orders.dto.RequestOrder;
import com.coffeorder.kakaoserver.orders.service.OrdersService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class OrderController {

	private final OrdersService ordersService;

	@PostMapping("/charge")
	public DataResponse showMenu(@RequestBody RequestCharge requestCharge, HttpServletRequest request) {
		Long point = ordersService.charge(requestCharge, request);
		return new DataResponse(CHARGE_POINT_SUCCESS_MSG, point);
	}

	@PostMapping("/order")
	public DataResponse order(@RequestBody RequestOrder requestOrder, HttpServletRequest request) {
		Long point = ordersService.charge(requestCharge, request);
		return new DataResponse(CHARGE_POINT_SUCCESS_MSG, point);
	}

}

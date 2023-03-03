package com.coffeorder.kakaoserver.common.response;

import lombok.Getter;

@Getter
public enum ResponseMessage {

	ORDER_SUCCESS_MSG(200, "주문이 완료되었습니다"),
	SHOW_MENU_SUCCESS_MSG(200, "메뉴 조회를 성공했습니다."),
	CHARGE_POINT_SUCCESS_MSG(200, "포인트 충전이 완료되었습니다."),

	// signup
	CREATE_USER_SUCCESS_MSG(200, "회원가입이 성공했습니다."),

	// login
	LOGIN_USER_SUCCESS_MSG(200, "로그인이 성공했습니다.");

	private final int status;
	private final String msg;

	ResponseMessage(final int status, final String msg) {
		this.status = status;
		this.msg = msg;
	}
}

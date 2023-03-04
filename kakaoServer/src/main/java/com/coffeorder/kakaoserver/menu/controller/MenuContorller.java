package com.coffeorder.kakaoserver.menu.controller;

import static com.coffeorder.kakaoserver.common.response.ResponseMessage.*;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffeorder.kakaoserver.common.response.DataResponse;
import com.coffeorder.kakaoserver.menu.entity.Menu;
import com.coffeorder.kakaoserver.menu.service.MenuService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/menu")
@RestController
public class MenuContorller {

	private final MenuService menuService;

	@GetMapping("/list")
	public DataResponse showMenu() {
		List<Menu> menuList =  menuService.showMenu();
		return new DataResponse(SHOW_MENU_SUCCESS_MSG, menuList);
	}

	@GetMapping("/popular/list")
	public DataResponse showPopularMenu() {
		List<Menu> popularList = menuService.showPopularMenu();
		return new DataResponse(SHOW_POPULAR_MENU_SUCCESS_MSG, popularList);
	}

}

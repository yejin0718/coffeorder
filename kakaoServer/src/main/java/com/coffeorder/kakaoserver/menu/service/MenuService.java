package com.coffeorder.kakaoserver.menu.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coffeorder.kakaoserver.menu.dto.ResponseMenu;
import com.coffeorder.kakaoserver.menu.entity.Menu;
import com.coffeorder.kakaoserver.menu.repository.MenuRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MenuService {

	private final MenuRepository menuRepository;

	@Transactional(readOnly = true)
	public List<Menu> showMenu() {
		List<Menu> menuList = menuRepository.findAll();
		return menuList;
	}

	@Transactional(readOnly = true)
	public List<Menu> showPopularMenu() {

	}
}

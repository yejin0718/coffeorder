package com.coffeorder.kakaoserver.orders.entity;

import com.coffeorder.kakaoserver.menu.entity.Menu;
import com.coffeorder.kakaoserver.users.entity.Users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ordersId;

	@ManyToOne
	@JoinColumn(name = "USERS_ID")
	private Users usersId ;

	@ManyToOne
	@JoinColumn(name = "MENU_ID")
	private Menu menu_id;

}

	// CREATE TABLE orders
	// (   orders_id int NOT NULL AUTO_INCREMENT,
	// 	users_id int NOT NULL,
	// 	menu_id int NOT NULL,
	// 	PRIMARY KEY (orders_id)                  );

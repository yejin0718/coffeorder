package com.coffeorder.kakaoserver.users.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer usersId;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private Long point;

	public Users(String email, String password){
		this.email = email;
		this.password = password;
		this.point = 0L;
	}

	public void update(Long point) {
		this.point = this.point + point;
	}

	public void pay(Long point) {
		this.point = this.point - point;
	}

}

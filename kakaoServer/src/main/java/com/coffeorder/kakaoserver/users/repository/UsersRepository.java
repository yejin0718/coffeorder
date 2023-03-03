package com.coffeorder.kakaoserver.users.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffeorder.kakaoserver.users.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

	Optional<Users> findByEmail(String email);

}

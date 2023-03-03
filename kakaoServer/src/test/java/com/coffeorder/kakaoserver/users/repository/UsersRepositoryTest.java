package com.coffeorder.kakaoserver.users.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.coffeorder.kakaoserver.users.entity.Users;

@DataJpaTest
public class UsersRepositoryTest {

	@Autowired
	private UsersRepository usersRepository;

	@BeforeEach
	public void setup() {

		Users users1 = new Users("이메일1","비밀번호1");
		usersRepository.save(users1);

		Users users2 = new Users("이메일2","비밀번호2");
		usersRepository.save(users1);
		
		System.out.println("member1.getEmail() = " + users1.getEmail());
		System.out.println("member2.getEmail() = " + users2.getEmail());
	}

	@Test
	@DisplayName("중복 이메일 확인")
	public void findByEmailTest() {
		/* given - 데이터 준비 */

		/* when - 테스트 실행 */
		// Users result1 = usersRepository.findByEmail("이메일1").get();
		// Users result2 = usersRepository.findByEmail("이메일2").get();

		/* then - 검증 */
		// assertThat(result1.getEmail()).isEqualTo("이메일1");
		// assertThat(result2.getEmail()).isEqualTo("이메일2");
		// System.out.println("result2.getEmail() = " + result2.getEmail());
	}

}

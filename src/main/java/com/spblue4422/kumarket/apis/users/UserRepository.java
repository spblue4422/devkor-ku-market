package com.spblue4422.kumarket.apis.users;

import com.spblue4422.kumarket.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public Optional<User> findUserByUserNameEquals(String userName);
}

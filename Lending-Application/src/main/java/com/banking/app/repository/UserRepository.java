package com.banking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.app.entity_model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByUserIdAndPassword(Integer userId, String password);

	public User findByUserName(String username);
}

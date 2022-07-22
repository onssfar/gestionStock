package com.management.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.management.demo.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT user FROM User user WHERE user.username = :username AND user.password = :password")
	public User findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}

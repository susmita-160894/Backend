package com.example.spring_security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.spring_security.entity.UserRegTable;

@EnableJpaRepositories
@Repository
public interface UserRegRepository extends JpaRepository<UserRegTable, Integer> {

	Optional<UserRegTable> findOneByEmailAndPassword(String email, String password);

	UserRegTable findByEmail(String email);

	@Modifying
	@Query("update UserRegTable set firstName=?1 ,lastName=?2, mobileNo=?3, password=?4 where email=?5 and password=?6")
	int updateUser(String updatesFirstName, String updatesLastName, String updatedMobileNo, String updatesPassword,
			String email, String password);

}

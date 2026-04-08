package fr.fms.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.fms.entities.MyUser;

public interface MyUserRepository extends JpaRepository<MyUser, Long> {
	Optional<MyUser> findByUsername(String username);
}

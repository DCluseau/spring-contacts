package fr.fms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.fms.entities.Contact;
import fr.fms.entities.MyUser;

public interface ContactRepository extends JpaRepository<Contact, Long> {
	public List<Contact> findByUser(MyUser user);
	public List<Contact> findByUserAndLastnameContains(MyUser user, String lastname);
}

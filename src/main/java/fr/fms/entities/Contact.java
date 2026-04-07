package fr.fms.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Contact implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(max=50)
	private String firstname;
	@NotNull
	@Size(min=3,max=50)
	private String lastname;
	@NotNull
	@Size(min=5,max=50)
	private String email;
	private String phoneNumber;
	private String address;
	@ManyToOne
	private Category category;
	@ManyToOne
	private User user;
	
	public Contact(String lastname, String email, User user, Category category) {
		this.lastname = lastname;
		this.email =  email;
		this.user = user;
		this.category = category;
	}

}

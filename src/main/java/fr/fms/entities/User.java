package fr.fms.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min=3,max=50)
	private String username;
	@NotNull
	@Size(min=5,max=50)
	private String pwd;
	private String email;
	@ColumnDefault("false")
	private boolean isConnected;
	
	@OneToMany(mappedBy = "user")
	private List<Contact> contacts;
	
	public User(String username, String pwd, String email) {
		this.username = username;
		this.pwd = pwd;
		this.email = email;
	}
}

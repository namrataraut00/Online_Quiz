package quiz.entity;

import javax.persistence.*;
import static testdb.AESAlgorithm.dt;

import static testdb.AESAlgorithm.en;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Entity
@Table(name = "User")
public class User {
	
	public User() {
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() throws GeneralSecurityException, IOException {
		System.out.println(dt(password));
		return dt(password);
	}

	public void setPassword(String password) throws GeneralSecurityException, IOException {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", role=" + role + ", email=" + email + ", password=" + password
				+ "]";
	}
	
	public User(String name, String email, String password, String userRole) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = userRole;
	}

}

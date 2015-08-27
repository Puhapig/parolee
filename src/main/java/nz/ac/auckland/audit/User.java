package nz.ac.auckland.audit;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Access( AccessType.FIELD )
public class User {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long _id;
	
	@Column(name="USERNAME", nullable=false, length=30, unique=true)
	private String _username;
	
	@Column(name="LASTNAME", nullable=false, length=30)
	private String _lastname;
	
	@Column(name="FIRSTNAME", nullable=false, length=30)
	private String _firstname;
	
	public User(String username, String lastname, String firstname) {
		_username = username;
		_lastname = lastname;
		_firstname = firstname;
	}
	
	public User(String username) {
		this(username, null, null);
	}
	
	protected User() {}
	
	public Long getId() {
		return _id;
	}
	
	public String getUsername() {
		return _username;
	}
	
	public String getLastname() {
		return _lastname;
	}
	
	public String getFirstname() {
		return _firstname;
	}
}

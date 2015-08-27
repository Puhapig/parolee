package nz.ac.auckland.audit;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AuditEntry {
	
	public enum CrudOperation {Create, Retrieve, Update, Delete}
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long _id;
	
	@Column(name="METHOD EXECUTED", nullable=false, length=30)
	private CrudOperation _crudOperator;
	
	@Column(name="URI", nullable=false, length=30)
	private String _uri;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private User _user;
	
	@Column(name="TIMESTAMP", nullable=false, length=30)
	private Date _timestamp;
	
	public AuditEntry(CrudOperation crudOp, String uri, User user) {
		_crudOperator = crudOp;
		_uri = uri;
		_user = user;
		_timestamp = new Date();
	}
	
	protected AuditEntry() {}
	
	public Long getId() {
		return _id;
	}
	
	public CrudOperation getCrudOperation() {
		return _crudOperator;
	}
	
	public String getUri() {
		return _uri;
	}
	
	public User getUser() {
		return _user;
	}
	
	public Date getTimestamp() {
		return _timestamp;
	}
}

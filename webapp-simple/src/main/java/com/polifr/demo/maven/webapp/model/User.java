package com.polifr.demo.maven.webapp.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "\"T_UTENTI\"", schema = "spring")
public class User implements Serializable {

	private static final long serialVersionUID = 2181856340377954278L;

	@Id
	@Column(name = "\"ID\"")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userIdGenerator")
	@SequenceGenerator(name = "userIdGenerator", sequenceName = "\"SEQ_ID_UTENTI\"", allocationSize = 1)
	private Long id;

	@NotEmpty
	@Column(name = "\"NOME\"")
	private String name;
	
	@NotEmpty
	@Column(name = "\"COGNOME\"")
	private String surname;

	@NotEmpty
	@Column(name = "\"USERNAME\"")
	private String username;

	@Email
	@Column(name = "\"EMAIL\"")
	private String email;

	@Column(name = "\"ID_GRUPPO\"")
	private Long userGroupId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "\"TS_INS\"")
	private Calendar userCreation;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "\"LAST_UPDATE\"")
	private Calendar userModification;

	@ManyToOne
	@JoinColumn(name = "\"ID_GRUPPO\"", insertable = false, updatable = false)
	private UserGroup userGroup;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getUserCreation() {
		return userCreation;
	}

	public void setUserCreation(Calendar userCreation) {
		this.userCreation = userCreation;
	}

	public Calendar getUserModification() {
		return userModification;
	}

	public void setUserModification(Calendar userModification) {
		this.userModification = userModification;
	}

	public Long getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(Long userGroupId) {
		this.userGroupId = userGroupId;
	}

	public UserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

	@PrePersist
	void insertTimestamps() {
		this.userCreation = Calendar.getInstance();
		this.userModification = Calendar.getInstance();
	}
	
	@PreUpdate
	void updateTimestamps() {
		this.userModification = Calendar.getInstance();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

package com.polifr.demo.maven.webapp.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "\"T_GRUPPI\"", schema = "spring")
public class UserGroup implements Serializable {

	private static final long serialVersionUID = -5490691050506653873L;

	@Id
	@Column(name = "\"ID\"")
	private Long id;
	
	@Column(name = "\"NOME\"")
	private String name;

	@OneToMany(mappedBy = "userGroup", fetch = FetchType.LAZY)
	private Set<User> groupUsers = new HashSet<User>();

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

	public Set<User> getGroupUsers() {
		return groupUsers;
	}

	public void setGroupUsers(Set<User> groupUsers) {
		this.groupUsers = groupUsers;
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
		UserGroup other = (UserGroup) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

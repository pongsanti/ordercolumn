package com.popsicle.example.data.model;

import javax.persistence.*;

@Entity
@Table(name = "Account")
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long accountId;

	private String accountName;

	@ManyToOne
	@JoinColumn(name="USERID", nullable=false)
	private User user;

	public Long getAccountId() {
		return this.accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
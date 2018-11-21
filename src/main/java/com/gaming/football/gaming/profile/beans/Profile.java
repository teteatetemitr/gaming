package com.gaming.football.gaming.profile.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="profile")
public class Profile implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int idProfile;
	@Column(name="username")
	private String userName;
	@Column(name="firstname")
	private String firstName;
	@Column(name="lastname")
	private String lastName;
	@Column(name="primaryemail")
	private String primaryEmail;
	@Column(name="alternateemail")
	private String alternateEmail;
	@Transient
	private String confirmPassword;
	@Transient
	private String alternatePassword;
	@Transient
	private String userNameChange;
	@Column(name="password")
	private String password;
	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPrimaryEmail() {
		return primaryEmail;
	}
	public String getAlternateEmail() {
		return alternateEmail;
	}

	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public int getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(int idProfile) {
		this.idProfile = idProfile;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserNameChange() {
		return userNameChange;
	}

	public void setUserNameChange(String userNameChange) {
		this.userNameChange = userNameChange;
	}

	public String getAlternatePassword() {
		return alternatePassword;
	}

	public void setAlternatePassword(String alternatePassword) {
		this.alternatePassword = alternatePassword;
	}
	
	

}

package com.typicode.user.objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.typicode.user.objects.RootData;

import java.util.List;

public class GetUserResponse {


	private Long id;

	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("last_name")
	private String lastName;
	private String avatar;

	public Long getId() {
	return id;
	}

	public void setId(Long id) {
	this.id = id;
	}

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

	public String getAvatar() {
	return avatar;
	}

	public void setAvatar(String avatar) {
	this.avatar = avatar;
	}

}

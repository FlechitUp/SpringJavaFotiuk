package com.xime.bupho.request;

public class RequestUser {

  private Long id;
  private String username;
  private String mail;
  private String password;

  public RequestUser(Long id, String username, String mail, String password) {
	this.id = id;
    this.username = username;  
    this.password = password;
    this.mail = mail;
  }

  public RequestUser() {
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
  
  public String getPassword() {
	  return password;
  }

  public void setPassword(String password) {
	this.password = password;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }
}

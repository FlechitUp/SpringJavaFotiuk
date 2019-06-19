package com.xime.bupho.service;

import com.xime.bupho.model.PhotoModel;
import com.xime.bupho.model.UserModel;
import com.xime.bupho.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository repository;

  @Autowired
  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  public List<UserModel> findAll() {
    return this.repository.findAll();
  }

  public UserModel findById(Long id) {
    return this.repository.findOne(id);
  }

  public UserModel findByUsername(String username) {
    return this.repository.findByUsername(username);
  }

  public UserModel save(UserModel user) {
    return this.repository.save(user);
  }

  public boolean usernameExist(String username) {
    UserModel user = this.repository.findByUsername(username);
    if (user == null) {
      return false;
    } else {
      return true;
    }
  }
  
  public boolean mailExist(String mail) {
	    UserModel user = this.repository.findByMail(mail);
	    if (user == null) {
	      return false;
	    } else {
	      return true;
	    }
	  }

  public boolean passwordRight(String password) {
	  UserModel user = this.repository.findByPassword(password);
	  if (user == null) {
		  return false;
	  }
	  return true;
  }
  
  public List<PhotoModel> photosOfUserId(Long id) {
    return this.repository.photosOfUserId(id);
  }

}

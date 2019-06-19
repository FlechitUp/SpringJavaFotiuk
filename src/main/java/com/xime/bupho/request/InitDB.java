package com.xime.bupho.request;

import com.xime.bupho.model.PhotoModel;
import com.xime.bupho.model.UserModel;
import com.xime.bupho.repository.PhotoRepository;
import com.xime.bupho.repository.UserRepository;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.company.Company;
import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.text.TextProducer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitDB {

  private final UserRepository userRepository;
  private final PhotoRepository photoRepository;  

  private Fairy fairy = Fairy.create();

  @Autowired
  public InitDB(UserRepository userRepository, PhotoRepository photoRepository) {
	System.out.println("bd start");
    this.userRepository = userRepository;
    this.photoRepository = photoRepository;
    
  }

  @PostConstruct
  public void insertAll() {
    List<UserModel> users = this.insertUsers();
    List<PhotoModel> photos = this.insertPhotos(users);
    
  }

  private List<UserModel> insertUsers() {
    List<UserModel> usersmodel = new ArrayList<>();
    for (int i = 1; i <= 4; i++) {
      Person person = this.fairy.person();
      UserModel user = new UserModel();
      
      user.setId(new Long (i));//(Long.format("user%d", i));//(new Long (i));
      user.setUsername(person.getFirstName());      
      user.setMail(person.getEmail());
      user.setPassword("123");

      usersmodel.add(user);
    }
    this.userRepository.save(usersmodel);
    return usersmodel;
  }

  private List<PhotoModel> insertPhotos(List<UserModel> users) {	
	List<PhotoModel> photosList = new ArrayList<>();
	for(UserModel user: users) {
		for(int i = 0 ;i < 5; i++ ) {
			Company company = this.fairy.company();
			PhotoModel photo = new PhotoModel();
			//photo.setName("photo"+ Integer.toString(i)+".jpg");
			photo.setName(company.getName()+".jpg");
			photo.setPrice(80+i);
			user.setPhoto(photo);
			this.photoRepository.save(photo);
		}
		this.userRepository.save(users);
	}
	System.out.println("photos created");
	this.photoRepository.save(photosList);
	return photosList;
  }
}

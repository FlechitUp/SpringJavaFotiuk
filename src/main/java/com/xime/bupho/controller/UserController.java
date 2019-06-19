package com.xime.bupho.controller;

import com.xime.bupho.model.UserModel;
import com.xime.bupho.request.RequestPhoto;
import com.xime.bupho.request.RequestUser;
import com.xime.bupho.service.PhotoService;
import com.xime.bupho.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

  @Autowired
  UserService userService;
  
  @Autowired
  PhotoService photoService;

  @RequestMapping(value = "/register")
  public String index(Model model) {
	System.out.println("Register");
    model.addAttribute("users", this.userService.findAll());
    //model.addAttribute("photos", this.photoService.findAll());
    model.addAttribute("newUser", new RequestUser());    
    //return "user/userlist";
    return "story/register";
  }
    

  @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
  public String userId(@PathVariable("id") Long id, Model model) {
	System.out.println(" GET ID METHOD");
    UserModel user = this.userService.findById(id);
    if (user == null) {
      model.addAttribute("messageWarn", String.format("User with id %d doesn't exists.", id));
    } else {
      model.addAttribute("user", user);
      model.addAttribute("id", id);
    }
    return "story/userprofile";
  }
  
  /**********************
   * User register POST *
   **********************/
  @RequestMapping(value = "/users", method = RequestMethod.POST)
  public String newUser(@ModelAttribute("newUser") RequestUser requestUser, Model model, RedirectAttributes redirectAtt) {
	System.out.println("paso if"); 
    if (this.userService.mailExist(requestUser.getMail())) {    	
      redirectAtt.addFlashAttribute("messageWarn",
          String.format("This mail was registered before",
              requestUser.getMail()));
      return "redirect:/register";
    }    
    UserModel user = new UserModel();
    user.setMail(requestUser.getMail());    
    user.setUsername(requestUser.getUsername());
    user.setPassword(requestUser.getPassword());//("123");    
    this.userService.save(user);
    System.out.println("profi");
    model.addAttribute("id",user.getId());
    return userId(user.getId(), model);//"story/userprofile";
  }
  
  
  /******************
   * User login GET *
   ******************/
  @RequestMapping(value = "/login")
  public String loginView(Model model ) {
	  
	  model.addAttribute("oldUser", new RequestUser());
	  return "story/login";
  }
  /********************
   * User login  POST *
   ********************/
  @RequestMapping(value = "/userprofile", method = RequestMethod.POST	)
  public String loginUser(@ModelAttribute("oldUser") RequestUser requestUser,RedirectAttributes redirectAtt) {
	  System.out.println("FOr here");
	  if (this.userService.usernameExist(requestUser.getUsername())) {
		  //TODO > change way to compare password
		  System.out.println("OKS user name exist");
		  if(this.userService.passwordRight(requestUser.getPassword())) {
			  System.out.println("OKS user passw exist");
			  return "story/users";
			  //return userId(user.getId(), model);
		  }
	  }
	  System.out.println("user not exist");
	  redirectAtt.addFlashAttribute("messageWarn1", String.format("User not registered", requestUser.getUsername()));
	  return "redirect:/userprofile";
  }
  
 /* @RequestMapping(value = "/users")
  public String userProfile(Model model) {
	  System.out.println("For here");
	  model.addAttribute("oldUser", new RequestUser());
	  model.addAttribute("myphotos", this.photoService.findAll());
	  return "story/userprofile";
  }*/

  @RequestMapping(value = "/addphoto")
  public String addPhoto (Model model) {
	  System.out.println("For here");
	  return "story/addphoto";
  }
  
  @RequestMapping(value = "/addphoto", method = RequestMethod.POST)
  public String addPhoto (@ModelAttribute("newUser") RequestUser requestUser, @ModelAttribute("newphoto") RequestPhoto requestphoto,  Model model) {
	  //System.out.println("For here");
	  
	  return "story/addphoto";
  }
  
}

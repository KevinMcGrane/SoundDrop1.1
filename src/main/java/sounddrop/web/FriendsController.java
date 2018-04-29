package sounddrop.web;

import sounddrop.model.User;

import sounddrop.service.UserService;

import java.security.Principal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/user/{username}")
public class FriendsController {

	private final UserService userService;


	@Autowired
	public FriendsController(UserService userService) {
		this.userService = userService;
	}

	@ModelAttribute
	public User user(@PathVariable("username") String username) {
		return userService.findByUsername(username);
	}



	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String doIdPut(@PathVariable String username, Model model, Principal principal) {
	    User friendRequest = userService.findByUsername(username);
	    String name = principal.getName();
		User currentUser = userService.findByUsername(name);
	    userService.addFriend(currentUser, friendRequest);
	    model.addAttribute("user", friendRequest);
	    return "redirect:/friends";
	  }
	
	@RequestMapping(value = "/remove/{friendId}", method = RequestMethod.POST)
	  public String doIdDelete(@PathVariable("friendId") Long friendId, Model model, Principal principal) {
	    User friend = userService.findById(friendId);
	    String name = principal.getName();
		User user = userService.findByUsername(name);
	    userService.removeFriends(user, friend);

	    model.addAttribute("user", friend);
	    return "redirect:/user/{username}";
	  }
}


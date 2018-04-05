package sounddrop.web;

import sounddrop.model.PostText;
import sounddrop.model.User;
import sounddrop.service.PostTextService;
import sounddrop.service.SecurityService;
import sounddrop.service.UserService;
import sounddrop.validator.UserValidator;

import java.security.Principal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


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

//	@RequestMapping(method = RequestMethod.GET)
//	 public String doGet(@ModelAttribute User user, Model model) {
//	    model.addAttribute("user", user);
//	    return "friends";
//	  }

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String doIdPut(@PathVariable String username, Model model, Principal principal) {
	    User friendRequest = userService.findByUsername(username);
	    String name = principal.getName();
		User currentUser = userService.findByUsername(name);
	    userService.addFriend(currentUser, friendRequest);
	    model.addAttribute("user", friendRequest);
	    return "redirect:/user/{username}";
	  }
	
	@RequestMapping(value = "/{remove}", method = RequestMethod.POST)
	  public String doIdDelete(@ModelAttribute User user, @PathVariable("friendId") Long friendId, Model model) {
	    User friend = userService.findById(friendId);
	    userService.removeFriends(user, friend);

	    model.addAttribute("user", friend);
	    return "redirect:/user/{username}";
	  }
}


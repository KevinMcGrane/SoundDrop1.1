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
@RequestMapping("/user/{username}/friendrequests")
public class FriendRequestController {
	@Autowired
	private UserService userService;
	


	@Autowired
	public FriendRequestController(UserService userService) {
		this.userService = userService;
	}

	@ModelAttribute
	public User user(@PathVariable("username") String username) {
		return userService.findByUsername(username);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doPost(@ModelAttribute User user, Model model, Principal principal) {
		String name = principal.getName();
		User currentUser = userService.findByUsername(name);
		userService.addFriendRequest(currentUser, user);
 
		
		model.addAttribute("user", user);  
		model.addAttribute("currentUser", currentUser);

		return "redirect:/user/{username}";
	}

	@RequestMapping(path = "/{friendRequestId}", method = RequestMethod.POST)
	public String doIdDelete(@ModelAttribute User user, Model model,
			@PathVariable("friendRequestId") Long friendRequestId, Principal principal) {
		String name = principal.getName();
		User currentUser = userService.findByUsername(name);
		User friendRequest = userService.findById(friendRequestId);
		userService.removeFriendRequests(friendRequest, currentUser);
		model.addAttribute("user", friendRequest);
		return "redirect:/user/{username}";
	}
	
	@RequestMapping(path = "/cancel", method = RequestMethod.POST)
	public String doIdDelete1(@ModelAttribute User user, Model model, Principal principal) {
		String name = principal.getName();
		User currentUser = userService.findByUsername(name);
		userService.removeFriendRequests(currentUser, user);
		model.addAttribute("user", user);
		return "redirect:/friends";
	}
	
	
}


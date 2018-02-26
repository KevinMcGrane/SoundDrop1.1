package sounddrop.web;

import sounddrop.model.PostText;
import sounddrop.model.User;
import sounddrop.repository.UserRepository;
import sounddrop.service.PostTextService;
import sounddrop.service.SecurityService;
import sounddrop.service.UserService;
import sounddrop.validator.UserValidator;

import java.security.Principal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

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
		return "redirect:/user/{username}";
	}
	
	
}


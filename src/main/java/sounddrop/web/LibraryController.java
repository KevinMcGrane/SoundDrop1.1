package sounddrop.web;

import java.security.Principal;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sounddrop.model.Playlist;
import sounddrop.model.PostText;
import sounddrop.model.Track;
import sounddrop.model.User;
import sounddrop.service.PlaylistService;
import sounddrop.service.UserService;

@Controller
public class LibraryController {
	@Autowired
	UserService userService;
	
	@Autowired
	PlaylistService playlistService;

	
	@RequestMapping(value = { "/library" }, method = RequestMethod.GET)
	public String library(Model model, Principal principal) {
		User currentUser = userService.findByUsername(principal.getName());
		Set<User> friends = currentUser.getFriends();
		int incomingRequestsCount = currentUser.getIncomingFriendRequests().size();
		model.addAttribute("count", incomingRequestsCount);
		model.addAttribute("friends", friends);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("playlistForm", new Playlist());
		return "library";
	}
	
	@RequestMapping(value = { "/playlist" }, method = RequestMethod.POST)
	public String addPostText(@ModelAttribute("playlistForm") Playlist playlistForm, BindingResult bindingResult,
			Model model, Principal principal) {

		if (bindingResult.hasErrors()) {
			return "welcome";
		}
		String name = principal.getName();
		User user = userService.findByUsername(name);
		playlistService.save(playlistForm, user);

		return "redirect:/library";
	}
}

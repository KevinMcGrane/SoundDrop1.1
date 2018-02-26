package sounddrop.web;

import sounddrop.model.Genre;
import sounddrop.model.PostText;
import sounddrop.model.User;
import sounddrop.repository.GenreRepository;
import sounddrop.repository.PostTextRepository;
import sounddrop.service.GenreService;
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
public class UserController {
    @Autowired
    private UserService userService;
    
    @Autowired
    private PostTextService postTextService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private GenreService genreService;
    
    
    
//    @RequestMapping(value = "/registration", method = RequestMethod.GET)
//    public String registration(Model model) {
//        model.addAttribute("userForm", new User());
//
//        return "registration";
//    }
   
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        model.addAttribute("userForm", new User());

        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

  

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model, Principal principal) {
    	User currentUser = userService.findByUsername(principal.getName());
    	List<PostText> postTextList = postTextService.getFeed(currentUser.getFriends(), principal.getName());
    	Set<User> friends = currentUser.getFriends();
    	int incomingRequestsCount = currentUser.getIncomingFriendRequests().size();
    	model.addAttribute("count", incomingRequestsCount);
    	model.addAttribute("postTextForm", new PostText());
    	model.addAttribute("postTextList", postTextList);
    	model.addAttribute("friends", friends);
    	model.addAttribute("currentUser", currentUser);
        return "welcome";
    }
    
    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.POST)
    public String addPostText(@ModelAttribute("postTextForm") PostText postTextForm, BindingResult bindingResult, Model model, Principal principal) {
        
        if (bindingResult.hasErrors()) {
            return "welcome";
        }
        String name = principal.getName();
        postTextService.save(postTextForm, name);


        return "redirect:/welcome";
    }
    
    @RequestMapping(value = "/deletepost/{postTextId}", method = RequestMethod.POST)
	  public String doIdDelete(@PathVariable long postTextId, PostText postText) {
    	postText = postTextService.findByPostTextId(postTextId);
	    postTextService.delete(postText);
	    return "redirect:/welcome";
	  }    
    @RequestMapping(value= {"/account"}, method = RequestMethod.GET)
	public String account(Model model, Principal principal) {
    	String name = principal.getName();
    	User currentUser = userService.findByUsername(name);
    	int incomingRequestsCount = currentUser.getIncomingFriendRequests().size();
    	model.addAttribute("count", incomingRequestsCount);
    	model.addAttribute("postTextForm", new PostText());
    	model.addAttribute("user", userService.findUserWithPosts(name));
    	
		return "account";
	}
    
    @RequestMapping(value= {"/account"}, method = RequestMethod.POST)
 public String addPost(@ModelAttribute("postTextForm") PostText postTextForm, BindingResult bindingResult, Model model, Principal principal) {
        
        if (bindingResult.hasErrors()) {
            return "account";
        }
        String name = principal.getName();
        postTextService.save(postTextForm, name);


        return "redirect:/account";
    }
    
    @RequestMapping(value= {"/search"}, method = RequestMethod.GET)
    public String  users(@RequestParam("searchString") String searchString, Model model, Principal principal) {
    	List<User> userList = userService.findUserByLname(searchString);
    	String name = principal.getName();
    	User currentUser = userService.findByUsername(name);
    	int incomingRequestsCount = currentUser.getIncomingFriendRequests().size();
    	model.addAttribute("count", incomingRequestsCount);
    	model.addAttribute("userList", userList);
    	return "users";
    }
    
    @RequestMapping(value= {"/friends"}, method = RequestMethod.GET)
    public String  requests(Model model, Principal principal) {
    	User user = userService.findByUsername(principal.getName());
    	Set<User> requestList = user.getIncomingFriendRequests();
    	Set<User> orequestList = user.getOutgoingFriendRequests();
    	int incomingRequestsCount = user.getIncomingFriendRequests().size();
    	model.addAttribute("count", incomingRequestsCount);
    	model.addAttribute("requestList", requestList);
    	model.addAttribute("orequestList", orequestList);
    	model.addAttribute("friends", user.getFriends());
    	return "friends";
    }
    
   @RequestMapping(value="user/{username}", method=RequestMethod.GET)
    public String  userProfile(@PathVariable String username, Model model, Principal principal) {
		User user = userService.findUserWithPosts(username);
		model.addAttribute("user", user);
		String name = principal.getName();
		User currentUser = userService.findByUsername(name);
    	int incomingRequestsCount = currentUser.getIncomingFriendRequests().size();
    	model.addAttribute("count", incomingRequestsCount);
		model.addAttribute("currentUser", currentUser);
	
		return "profile";
    }
   
//   @RequestMapping(value="user/add/{username}", method=RequestMethod.GET)
//   public String  addFollower(@PathVariable String username, Model model, Principal principal) {
//	  User userToFollow = userService.findByUsername(username);
//	  String name = principal.getName();
//	  User currentUser = userService.findByUsername(name);
//	  userService.addFriendToFollow(currentUser, userToFollow);
//	  
//   	return "redirect:/user/" + username;
//   }
   
//   @RequestMapping(value = "/following")
//	public String showFollowing(Model model) {
//		
//		List<User> followingList = userService.getUsersIFollow();
//		model.addAttribute("following", followingList);
//		
//		return "users";
	//}

   
   @RequestMapping(value= {"/friendssearch"},  method=RequestMethod.GET)
   public String findFriends(@RequestParam("searchTerm") String searchTerm, Model model, Principal principal) {
	   List<User> userList = userService.findFriends(searchTerm);
	   String name = principal.getName();
   	User currentUser = userService.findByUsername(name);
   	int incomingRequestsCount = currentUser.getIncomingFriendRequests().size();
   	model.addAttribute("count", incomingRequestsCount);
   	model.addAttribute("userList", userList);
	   return "users";
   }
   
}


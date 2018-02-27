package sounddrop.web;

import sounddrop.model.PostText;
import sounddrop.model.User;
import sounddrop.service.AmazonClient;
import sounddrop.service.PostTextService;
import sounddrop.service.SecurityService;
import sounddrop.service.UserService;
import sounddrop.validator.UserValidator;

import java.security.Principal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/settings")
public class SettingsController {

	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private UserService userService;
	@Autowired
    private AmazonClient amazonClient;


	@Autowired
	public SettingsController(BCryptPasswordEncoder bCryptPasswordEncoder, UserService userService) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.userService = userService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String doGet(Model model, Principal principal) {
		String name = principal.getName();
    	User currentUser = userService.findByUsername(name);
    	int incomingRequestsCount = currentUser.getIncomingFriendRequests().size();
    	model.addAttribute("count", incomingRequestsCount);
		model.addAttribute("user", currentUser);
		model.addAttribute("bioSettings", new BioSettings());
		return "settings";
	}

	@RequestMapping(value = "/bio", method = RequestMethod.POST)
	public String bio(@ModelAttribute BioSettings bioSettings, Model model, Principal principal, User user) {
		String name = principal.getName();
		user = userService.findByUsername(name);
		user.setBio(bioSettings.getBio());
		user.setFname(bioSettings.getFname());
		user.setLname(bioSettings.getLname());
		userService.update(user);
		model.addAttribute("user", user);

		return "redirect:/settings?bio_success";
	}

	 @RequestMapping(value="profilepic", method = RequestMethod.POST)
	    public String addProfilePic(@RequestPart(value = "file") MultipartFile file, Model model, Principal principal) {
	        
	        String name = principal.getName(); 
	        this.amazonClient.uploadPic(file, name);
	        
	        return "redirect:/welcome";
	    }
	  
/*	@RequestMapping(value = "/password", method = RequestMethod.POST)
	public String password(@ModelAttribute PasswordSettings passwordSettings, Model model, Principal principal,
			User user, BCryptPasswordEncoder bCryptPasswordEncoder, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            return "settings";
        }
		String name = principal.getName();
		user = userService.findByUsername(name);
		user.setPassword(bCryptPasswordEncoder.encode(passwordSettings.getPassword()));
		userService.save(user);

		return "redirect:/settings?password_success";
	}*/

	public static class BioSettings {
		private String bio;
		private String fname;
		private String lname;

		public String getFname() {
			return fname;
		}

		public void setFname(String fname) {
			this.fname = fname;
		}

		public String getLname() {
			return lname;
		}

		public void setLname(String lname) {
			this.lname = lname;
		}

		public String getBio() {
			return bio;
		}

		public void setBio(String bio) {
			this.bio = bio;
		}

	}

	public static class PasswordSettings {

		private String password;

		private String passwordConfirm;

		public boolean isMatching() {
			return Objects.equals(password, passwordConfirm);
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getPasswordConfirm() {
			return passwordConfirm;
		}

		public void setPasswordConfirm(String passwordConfirm) {
			this.passwordConfirm = passwordConfirm;
		}
	}

}

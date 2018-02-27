package sounddrop.web;

import java.io.File;
import java.security.Principal;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;


import sounddrop.model.PostText;
import sounddrop.model.Track;
import sounddrop.model.User;
import sounddrop.service.AmazonClient;
import sounddrop.service.TrackService;
import sounddrop.service.UserService;


@Controller
@RequestMapping("/track")
public class TrackController {

	@Autowired
	private TrackService trackService;
	
    private AmazonClient amazonClient;
    
    private UserService userService;


	@RequestMapping(method = RequestMethod.GET)
		public String getForm(Model model) {
		return "file";
		}
	
	
	  @RequestMapping(method = RequestMethod.POST)
	    public String addTrack(@RequestParam("track") String track, @RequestParam("genre") String genre, @RequestParam("artist") String artist, @RequestPart(value = "file") MultipartFile file, Model model, Principal principal) {
	        
	        String name = principal.getName(); 
	        this.amazonClient.uploadFile(file, track, name, genre);
	        
	        return "redirect:/welcome";
	    }
	  
	  @Autowired
	    TrackController(AmazonClient amazonClient) {
	        this.amazonClient = amazonClient;
	    }
	    
	    @RequestMapping(value="file", method=RequestMethod.GET)
	    public String getUploadPage() {	
			return "fileUpload";
			}
	  
	
	  
	    
	}
	


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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import sounddrop.model.Genre;
import sounddrop.model.PostText;
import sounddrop.model.Track;
import sounddrop.model.User;
import sounddrop.service.AmazonClient;
import sounddrop.service.GenreService;
import sounddrop.service.TrackService;
import sounddrop.service.UserService;


@Controller
@RequestMapping("/track")
public class TrackController {

	@Autowired
	private TrackService trackService;
	
    private AmazonClient amazonClient;
    
    private UserService userService;
    
    private GenreService genreService;


	@RequestMapping(method = RequestMethod.GET)
		public String getForm(Model model) {
		return "file";
		}
	
	
	  @RequestMapping(method = RequestMethod.POST)
	    public String addTrack(@RequestParam("track") String trackName, @RequestParam("genre") String genreName, @RequestParam("artist") String artist, @RequestPart(value = "file") MultipartFile file, Model model, Principal principal) {
	        
	        String name = principal.getName(); 
	        Genre genre = genreService.findByName(genreName);
	        if (genre.getName().equals("Techno")) {
	        	System.out.println("True");
	        }
	        this.amazonClient.uploadFile(file, trackName, name, artist, genre);
	        
	        return "redirect:/welcome";
	    }
	  
	  @RequestMapping(value = "/deletetrack/{trackId}", method = RequestMethod.POST)
		public String doIdDelete(@PathVariable long trackId, Track track) {
			track = trackService.findByTrackId(trackId);
			trackService.delete(track);
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
	



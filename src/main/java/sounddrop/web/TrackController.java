package sounddrop.web;

import java.security.Principal;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import sounddrop.model.Comment;
import sounddrop.model.Genre;
import sounddrop.model.Track;
import sounddrop.model.User;
import sounddrop.service.AmazonClient;
import sounddrop.service.CommentService;
import sounddrop.service.GenreService;
import sounddrop.service.TrackService;
import sounddrop.service.UserService;


@Controller
@RequestMapping("/track")
public class TrackController {

	@Autowired
	private TrackService trackService;
	
    private AmazonClient amazonClient;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private GenreService genreService;
    
    @Autowired
    private CommentService commentService;


	@RequestMapping(method = RequestMethod.GET)
		public String getForm(Model model) {
		return "file";
		}
	
	
	  @RequestMapping(method = RequestMethod.POST)
	    public String addTrack(@RequestParam("track") String trackName, @RequestParam("genre") String genreName, @RequestParam("artist") String artist, @RequestPart(value = "file") MultipartFile file, Model model, Principal principal) {
	        
	        String name = principal.getName(); 
	        System.out.println(genreName);
			System.out.println(genreService.findByName("Techno").getName());
			System.out.println(genreService.findByName(genreName).getName());

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
	  
	  @RequestMapping(value = "/comment/{trackId}", method = RequestMethod.GET)
		public String getComments(@PathVariable long trackId, Model model) {
			Track track = trackService.findByTrackId(trackId);
			int commentsCount = track.getComments().size();
			model.addAttribute("commentCount", commentsCount);
			model.addAttribute("track", track);
			model.addAttribute("commentForm", new Comment());
			List<Comment> comments = track.getComments();
			model.addAttribute("comments", comments);
			return "trackComments";
		}
	  
	  @RequestMapping(value = "/comment/{trackId}", method = RequestMethod.POST)
		public String postComment(@PathVariable long trackId, Track track,
				@ModelAttribute("commentForm") Comment commentForm, BindingResult bindingResult, Model model,
				Principal principal) {
			if (bindingResult.hasErrors()) {
				return "trackComments";
			}
			track = trackService.findByTrackId(trackId);
			String name = principal.getName();
			User user = userService.findByUsername(name);
			commentService.saveTrackComment(commentForm, user, track);
			trackService.update(track.getId());
			return "redirect:/track/comment/{trackId}";
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
	



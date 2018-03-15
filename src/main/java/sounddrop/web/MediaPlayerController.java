package sounddrop.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sounddrop.model.Playlist;
import sounddrop.model.User;
import sounddrop.service.GenreService;
import sounddrop.service.PlaylistService;
import sounddrop.service.PostTextService;
import sounddrop.service.SecurityService;
import sounddrop.service.TrackService;
import sounddrop.service.UserService;
import sounddrop.validator.UserValidator;

@Controller
public class MediaPlayerController {
	@Autowired
	private UserService userService;

	@Autowired
	private PostTextService postTextService;

	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private TrackService trackService;

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private GenreService genreService;

	@Autowired
	private PlaylistService playlistService;
	
	
	
}

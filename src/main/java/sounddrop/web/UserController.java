
package sounddrop.web;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.mahout.cf.taste.common.TasteException;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sounddrop.model.Comment;
import sounddrop.model.Playlist;
import sounddrop.model.Post;
import sounddrop.model.PostText;
import sounddrop.model.Rating;
import sounddrop.model.Track;
import sounddrop.model.User;
import sounddrop.service.CommentService;
import sounddrop.service.PlaylistService;
import sounddrop.service.PostService;
import sounddrop.service.PostTextService;
import sounddrop.service.RatingService;
import sounddrop.service.SecurityService;
import sounddrop.service.TrackService;
import sounddrop.service.UserService;
import sounddrop.validator.UserValidator;

@Controller
public class UserController {
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
	private CommentService commentService;
	

	@Autowired
	private PostService postService;
	
	@Autowired
	private RatingService ratingService;

	@Autowired
	private PlaylistService playlistService;
	

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

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcome(Model model, Principal principal) throws IOException, TasteException {
		User currentUser = userService.findByUsername(principal.getName());
		Set<User> friends = currentUser.getFriends();
		int incomingRequestsCount = currentUser.getIncomingFriendRequests().size();
		Set<Track> trackList = currentUser.getTracks();
		List<Playlist> playlists = playlistService.findByUser(currentUser);
				JSONObject jObject = new JSONObject();
				int i = 1;
		try
		{
		    JSONArray jArray = new JSONArray();
		    for (Track track : trackList)
		    {
		         JSONObject trackJSON = new JSONObject();
		         trackJSON.put("track",i);
		         trackJSON.put("name", track.getTrackName());
		         trackJSON.put("artist", track.getArtist());
		         trackJSON.put("file", track.getFileName());
		         jArray.put(trackJSON);
		         i++;
		    }
		    jObject.put("tracks", jArray);
		    model.addAttribute("tracks", jArray);
		} catch (JSONException jse) {
		    jse.printStackTrace();
		}
		
		
		List<Post> userFeed = postService.getFeed(friends, currentUser);

		
		model.addAttribute("playlist", currentUser.getPlaylist());
		model.addAttribute("userFeed", userFeed);
		model.addAttribute("tracklist", trackList);
		model.addAttribute("count", incomingRequestsCount);
		model.addAttribute("postTextForm", new PostText());	
		model.addAttribute("friends", friends);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("playlists", playlists);

		return "welcome";
	}
	
	@RequestMapping(value = { "/welcome/{playlistName}" }, method = RequestMethod.GET)
	public String welcome1(@PathVariable String playlistName, Model model, Principal principal) {
		User currentUser = userService.findByUsername(principal.getName());
		Set<User> friends = currentUser.getFriends();
		int incomingRequestsCount = currentUser.getIncomingFriendRequests().size();
		Playlist playlist1 = playlistService.findByName(playlistName);
		Set<Track> playlist = playlist1.getTracks();
		Set<Track> trackList = trackService.findByUser(currentUser);
		List<Playlist> playlists = playlistService.findByUser(currentUser);
		JSONObject jObject = new JSONObject();
		int i = 1;
		try
		{
		    JSONArray jArray = new JSONArray();
		    for (Track track : playlist)
		    {
		         JSONObject trackJSON = new JSONObject();
		         trackJSON.put("track", i);
		         trackJSON.put("name", track.getTrackName());
		         trackJSON.put("artist", track.getArtist());
		         trackJSON.put("file", track.getFileName());
		         jArray.put(trackJSON);
		         i++;
		    }
		    jObject.put("tracks", jArray);
		    model.addAttribute("tracks", jArray);
		} catch (JSONException jse) {
		    jse.printStackTrace();
		}
		System.out.println(jObject);
		
		List<Post> userFeed = postService.getFeed(friends, currentUser);
		model.addAttribute("userFeed", userFeed);
		model.addAttribute("playlists", playlists);
		model.addAttribute("playlist", playlist);
		model.addAttribute("tracklist", trackList);
		model.addAttribute("count", incomingRequestsCount);
		model.addAttribute("postTextForm", new PostText());	
		model.addAttribute("friends", friends);
		model.addAttribute("currentUser", currentUser);
		
		
		return "welcome";
	}
	
	
	
	
	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.POST)
	public String addPostText(@ModelAttribute("postTextForm") PostText postTextForm, BindingResult bindingResult,
			Model model, Principal principal) {

		if (bindingResult.hasErrors()) {
			return "welcome";
		}
		String name = principal.getName();
		postTextService.save(postTextForm, name);

		return "redirect:/welcome";
	}

	@RequestMapping(value = "/deletepost/{postId}", method = RequestMethod.POST)
	public String doIdDelete(@PathVariable Long postId, Post post) {
		post = postService.findById(postId);
		postService.delete(post);
		return "redirect:/welcome";
	}

	@RequestMapping(value = "/comment/{postTextId}", method = RequestMethod.GET)
	public String getComments(@PathVariable long postTextId, Model model) {
		PostText postText = postTextService.findByPostTextId(postTextId);
		int commentsCount = postText.getComments().size();
		model.addAttribute("commentCount", commentsCount);
		model.addAttribute("postText", postText);
		model.addAttribute("commentForm", new Comment());
		Set<Comment> comments = postText.getComments();
		model.addAttribute("comments", comments);
		return "comments";
	}

	@RequestMapping(value = "/comment/{postTextId}", method = RequestMethod.POST)
	public String postComment(@PathVariable long postTextId, PostText postText,
			@ModelAttribute("commentForm") Comment commentForm, BindingResult bindingResult, Model model,
			Principal principal) {
		if (bindingResult.hasErrors()) {
			return "comments";
		}
		postText = postTextService.findByPostTextId(postTextId);
		String name = principal.getName();
		User user = userService.findByUsername(name);
		commentService.save(commentForm, user, postText);
		//postTextService.update(postText);
		return "redirect:/comment/{postTextId}";
	}

	@RequestMapping(value = { "/account" }, method = RequestMethod.GET)
	public String account(Model model, Principal principal) {
		String name = principal.getName();
		User currentUser = userService.findByUsername(name);
		int incomingRequestsCount = currentUser.getIncomingFriendRequests().size();
		List<Post> userFeed = postService.findByUser(currentUser);
		model.addAttribute("count", incomingRequestsCount);
		model.addAttribute("postTextForm", new PostText());
		model.addAttribute("user", currentUser);
		model.addAttribute("userFeed", userFeed);

		return "account";
	}

	@RequestMapping(value = { "/account" }, method = RequestMethod.POST)
	public String addPost(@ModelAttribute("postTextForm") PostText postTextForm, BindingResult bindingResult,
			Model model, Principal principal) {

		if (bindingResult.hasErrors()) {
			return "account";
		}
		String name = principal.getName();
		postTextService.save(postTextForm, name);

		return "redirect:/account";
	}

	@RequestMapping(value = { "/search" }, method = RequestMethod.GET)
	public String users(@RequestParam("searchString") String searchString, Model model, Principal principal) {
		User currentUser = userService.findByUsername(principal.getName());
		List<User> allList = userService.findAll();
		List<User> searchList = new ArrayList<>();
		for (User user : allList) {
			if (user.getLname().toLowerCase().contains(searchString.toLowerCase()) || user.getFname().toLowerCase().contains(searchString.toLowerCase()) || user.getUsername().toLowerCase().contains(searchString.toLowerCase())) {
			searchList.add(user);
			}
		}
		List<User> searchListFriends = new ArrayList<>();
		List<User> searchListOther = new ArrayList<>();

		for (User user : searchList) {
			if (currentUser.isFriendOf(user)) {
				searchListFriends.add(user);
			}else searchListOther.add(user);
		}


		int incomingRequestsCount = currentUser.getIncomingFriendRequests().size();
		model.addAttribute("friends", searchListFriends);
		model.addAttribute("other", searchListOther);
		model.addAttribute("count", incomingRequestsCount);
		model.addAttribute("userList", searchList);
		return "users";
	}

	@RequestMapping(value = { "/friends" }, method = RequestMethod.GET)
	public String requests(Model model, Principal principal) {
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

	@RequestMapping(value = "user/{username}", method = RequestMethod.GET)
	public String userProfile(@PathVariable String username, Model model, Principal principal) {
		User user = userService.findByUsername(username);
		
		String name = principal.getName();
		
		List<Post> userFeed = postService.findByUser(user);
		User currentUser = userService.findByUsername(name);
		
		int incomingRequestsCount = currentUser.getIncomingFriendRequests().size();
		model.addAttribute("user", user);
		model.addAttribute("userFeed", userFeed);
		model.addAttribute("count", incomingRequestsCount);
		model.addAttribute("currentUser", currentUser);
		if (name.equals(username)) {
			return account(model, principal);
		} else {

			return "profile";
		}
	}

	@RequestMapping(value = "playlist/{playlistName}", method = RequestMethod.GET)
	public String playlist(@PathVariable String playlistName, Model model, Principal principal) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		Playlist playlist1 = playlistService.findByName(playlistName);
		Set<Track> playlist = playlist1.getTracks();
		Set<Track> trackList = trackService.findByUser(currentUser);
		List<Playlist> playlists = playlistService.findByUser(currentUser);
		JSONObject jObject = new JSONObject();
		int i = 1;
		try
		{
		    JSONArray jArray = new JSONArray();
		    for (Track track : playlist)
		    {
		         JSONObject trackJSON = new JSONObject();
		         trackJSON.put("track", i);
		         trackJSON.put("name", track.getTrackName());
		         trackJSON.put("artist", track.getArtist());
		         trackJSON.put("file", track.getFileName());
		         jArray.put(trackJSON);
		         i++;
		    }
		    jObject.put("tracks", jArray);
		    model.addAttribute("tracks", jArray);
		} catch (JSONException jse) {
		    jse.printStackTrace();
		}
		System.out.println("tttttt");
		model.addAttribute("playlists", playlists);
		model.addAttribute("playlist", playlist);
		model.addAttribute("tracklist", trackList);
		model.addAttribute("postTextForm", new PostText());	
		model.addAttribute("currentUser", currentUser);

			return "post";
		
	}
	
	@RequestMapping(value = { "/rate" }, method = RequestMethod.GET)
	public String rate(@RequestParam(value="rating") float value,@RequestParam(value="id") Long id, Model model, Principal principal) {
		String name = principal.getName();
		User currentUser = userService.findByUsername(name);
		Track track = trackService.findByTrackId(id);
		Rating rating = new Rating();
		rating.setRating(value);
		rating.setTrack(track);
		rating.setUser(currentUser);
		ratingService.save(rating);
		
		
		return "redirect:/welcome";
		
	}
	
	
}



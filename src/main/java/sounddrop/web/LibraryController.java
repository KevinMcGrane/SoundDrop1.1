package sounddrop.web;

import java.security.Principal;
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

import sounddrop.model.Playlist;
import sounddrop.model.Track;
import sounddrop.model.User;
import sounddrop.service.PlaylistService;
import sounddrop.service.TrackService;
import sounddrop.service.UserService;

@Controller
@RequestMapping("/library")
public class LibraryController {
	@Autowired
	UserService userService;
	
	@Autowired
	PlaylistService playlistService;
	
	@Autowired
	TrackService trackService;

	
	@RequestMapping(method = RequestMethod.GET)
	public String library(Model model, Principal principal) throws TasteException {
		User currentUser = userService.findByUsername(principal.getName());
		Set<User> friends = currentUser.getFriends();
		int incomingRequestsCount = currentUser.getIncomingFriendRequests().size();
		Set<Track> trackList = currentUser.getTracks();
		List<Playlist> playlists = playlistService.findByUser(currentUser);
		model.addAttribute("playlists", playlists);
		model.addAttribute("tracklist", trackList);
		JSONObject jObject = new JSONObject();
		for (Track t : currentUser.getTracks()) {
			System.out.println(t.getTrackName());
		}
		int i = 1;
		try
		{
		    JSONArray jArray = new JSONArray();
		    for (Track track : trackList)
		    {
		         JSONObject trackJSON = new JSONObject();
		         trackJSON.put("track", i);
		         trackJSON.put("name", track.getTrackName());
		         trackJSON.put("artist", track.getArtist());
		         trackJSON.put("length", "0.00");
		         trackJSON.put("file", track.getFileName());
		         jArray.put(trackJSON);
		         i++;
		    }
		    jObject.put("tracks", jArray);
		    model.addAttribute("tracks", jArray);
		    System.out.println("1111111" +jArray);
		} catch (JSONException jse) {
		    jse.printStackTrace();
		}		
		
		List<Track> recommendedTracks = trackService.recommend(currentUser.getId());
		model.addAttribute("recommendedTracks", recommendedTracks);
		model.addAttribute("count", incomingRequestsCount);
		model.addAttribute("friends", friends);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("playlistForm", new Playlist());
		return "library";
	}
	
	@RequestMapping(value = { "/{playlistName}" },method = RequestMethod.GET)
	public String libraryPlaylist(@PathVariable String playlistName, Model model, Principal principal) throws TasteException {
		User currentUser = userService.findByUsername(principal.getName());
		Set<User> friends = currentUser.getFriends();
		int incomingRequestsCount = currentUser.getIncomingFriendRequests().size();
		Set<Track> trackList = currentUser.getTracks();
		List<Playlist> playlists = playlistService.findByUser(currentUser);
		Playlist playlist1 = playlistService.findByName(playlistName);
		Set<Track> playlist = playlist1.getTracks();
		model.addAttribute("playlists", playlists);
		model.addAttribute("tracklist", trackList);
		JSONObject jObject = new JSONObject();
		int i =1;
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
		List<Track> recommendedTracks = trackService.recommend(currentUser.getId());
		model.addAttribute("recommendedTracks", recommendedTracks);
		model.addAttribute("count", incomingRequestsCount);
		model.addAttribute("friends", friends);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("playlistForm", new Playlist());
		return "library";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String addPlaylist(@ModelAttribute("playlistForm") Playlist playlistForm, BindingResult bindingResult,
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

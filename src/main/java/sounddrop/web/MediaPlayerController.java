//package sounddrop.web;
//
//import java.security.Principal;
//import java.util.List;
//
//import org.codehaus.jettison.json.JSONArray;
//import org.codehaus.jettison.json.JSONException;
//import org.codehaus.jettison.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import sounddrop.model.Genre;
//import sounddrop.model.Playlist;
//import sounddrop.model.Track;
//import sounddrop.service.GenreService;
//import sounddrop.service.PlaylistService;
//import sounddrop.service.PostTextService;
//import sounddrop.service.SecurityService;
//import sounddrop.service.TrackService;
//import sounddrop.service.UserService;
//import sounddrop.validator.UserValidator;
//
//@Controller
//public class MediaPlayerController {
//	@Autowired
//	private UserService userService;
//
//	@Autowired
//	private PostTextService postTextService;
//
//	@Autowired
//	private SecurityService securityService;
//
//	@Autowired
//	private TrackService trackService;
//
//	@Autowired
//	private UserValidator userValidator;
//
//	@Autowired
//	private GenreService genreService;
//
//	@Autowired
//	private PlaylistService playlistService;
//
//	@RequestMapping(method = RequestMethod.GET)
//	public String changePlaylist(@RequestParam("playlist") String playlistName, Principal principal, Model model) {
//
//		String name = principal.getName();
//		System.out.println(playlistName);
//		System.out.println(playlistService.findByName("").getName());
//		System.out.println(playlistService.findByName(playlistName).getName());
//
//		Playlist playlist = playlistService.findByName(playlistName);
//		List<Track> trackList = playlist.getTracks();
//
//		JSONObject jObject = new JSONObject();
//		try {
//			JSONArray jArray = new JSONArray();
//			for (Track track : trackList) {
//				JSONObject trackJSON = new JSONObject();
//				trackJSON.put("track", track.getId());
//				trackJSON.put("name", track.getTrackName());
//				trackJSON.put("length", "0.00");
//				trackJSON.put("file", track.getFileName());
//				jArray.put(trackJSON);
//			}
//			jObject.put("tracks", jArray);
//			model.addAttribute("tracks", jArray);
//			System.out.println("1111111" + jArray);
//		} catch (JSONException jse) {
//			jse.printStackTrace();
//		}
//
//		return "redirect:/welcome";
//	}
//
//}

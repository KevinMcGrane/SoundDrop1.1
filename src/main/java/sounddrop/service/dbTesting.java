package sounddrop.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import sounddrop.model.Genre;
import sounddrop.model.Playlist;
import sounddrop.model.PostText;
import sounddrop.model.Rating;
import sounddrop.model.Role;
import sounddrop.model.Track;
import sounddrop.model.User;
import sounddrop.repository.GenreRepository;
import sounddrop.repository.PlaylistRepository;
import sounddrop.repository.PostTextRepository;
import sounddrop.repository.RatingRepository;
import sounddrop.repository.RoleRepository;
import sounddrop.repository.TrackRepository;
import sounddrop.repository.UserRepository;

@Transactional
@Service
public class dbTesting {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TrackRepository trackRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PostTextRepository postTextRepository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TrackService trackService;
	
	@Autowired
	private PlaylistRepository playlistRepository;
	
	@Autowired
	private RatingRepository rating1Repository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostConstruct
	public void init() {
		


		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		grantedAuthorities.add(new SimpleGrantedAuthority(roleUser.getName()));

		User user = new User();
		String password = "test";
		user.setUsername("kevin97");
		user.setPassword(bCryptPasswordEncoder.encode(password));
		user.setFname("Kevin");
		user.setLname("McGrane");
		user.setBio("Have a great day!");
		
		
		
		HashSet<Role> roles = new HashSet<>();
		roles.add(roleUser);
		user.setRoles(roles);
		userRepository.save(user);

		

		HashSet<User> requests = new HashSet<>();
		requests.add(user);
		User user2 = new User();
		String password2 = "test";
		user2.setUsername("user2");
		user2.setPassword(bCryptPasswordEncoder.encode(password2));
		user2.setFname("Brian");
		user2.setLname("MacCourt");
		user2.setBio("Hi there!");
	
		
		user2.setRoles(roles);
		userRepository.save(user2);
		
		
		
		User user3 = new User();
		user3.setUsername("user3");
		user3.setPassword(bCryptPasswordEncoder.encode(password2));
		user3.setFname("John");
		user3.setLname("Reilly");
		user3.setBio("Hi there!")	;	
		user3.setRoles(roles);
		userRepository.save(user3);
		
		User user4 = new User();
		user4.setUsername("user4");
		user4.setPassword(bCryptPasswordEncoder.encode(password2));
		user4.setFname("Joe");
		user4.setLname("Bloggs");
		user4.setBio("Hi there!");
		user4.setRoles(roles);
		userRepository.save(user4);
		
		User user5 = new User();
		user5.setUsername("user5");
		user5.setPassword(bCryptPasswordEncoder.encode(password2));
		user5.setFname("John");
		user5.setLname("Bloggs");
		user5.setBio("Hi there!")	;	
		user5.setRoles(roles);
		userRepository.save(user5);	
		
		PostText postText = new PostText();
		postText.setContent("Hi");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		postText.setPublishTime(timestamp);
		postText.setUser(user);
	    postTextRepository.save(postText);
	    
	    PostText postText2 = new PostText();
		postText2.setContent("Sup");
		postText2.setPublishTime(timestamp);
		postText2.setUser(user2);
	    postTextRepository.save(postText2);

	    Genre genre = new Genre();
	    genre.setName("Techno");
	    genreRepository.save(genre);
	    
	    Genre genre1 = new Genre();
	    genre1.setName("House");
	    genreRepository.save(genre1);
	    
	    Genre genre2 = new Genre();
	    genre2.setName("Tech House");
	    genreRepository.save(genre2);
	    
	    Genre genre3 = new Genre();
	    genre3.setName("Trance");
	    genreRepository.save(genre3);
	    
	    Track track1 = new Track();
	    track1.setTrackName(("It's Only Real"));
	    track1.setGenre(genre1);
	    track1.setArtist("Denis Sulta");
	    track1.setUser(user);
	    track1.setPublishTime(timestamp);
	    track1.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track1);
	    
	    Track track2 = new Track();
	    track2.setTrackName(("You Don't Know Me"));
	    track2.setGenre(genre1);
	    track2.setArtist("Armand Van Helden");
	    track2.setUser(user);
	    track2.setPublishTime(timestamp);
	    track2.setFileName("1521220048923-Armand_Van_Helden-You_Don't_Know_Me.mp3");
	    trackRepository.save(track2);
	     
	    
	   Track track3 = new Track();
	    track3.setTrackName(("Track 3"));
	    track3.setGenre(genre1);
	    track3.setArtist("Artist 3");
	    track3.setUser(user);
	    track3.setPublishTime(timestamp);
	    track3.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track3);
	    
	    Track track4 = new Track();
	    track4.setTrackName(("Track 4"));
	    track4.setGenre(genre1);
	    track4.setArtist("Artist 4");
	    track4.setUser(user);
	    track4.setPublishTime(timestamp);
	    track4.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track4);
	    
	    Track track5 = new Track();
	    track5.setTrackName(("Track 5"));
	    track5.setGenre(genre1);
	    track5.setArtist("Artist 5");
	    track5.setUser(user);
	    track5.setPublishTime(timestamp);
	    track5.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track5);
	    
	    Track track6 = new Track();
	    track6.setTrackName(("Track 6"));
	    track6.setGenre(genre1);
	    track6.setArtist("Artist 6");
	    track6.setUser(user);
	    track6.setPublishTime(timestamp);
	    track6.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track6);
	    
	    Track track7 = new Track();
	    track7.setTrackName(("Track 7"));
	    track7.setGenre(genre1);
	    track7.setArtist("Artist 7");
	    track7.setUser(user);
	    track7.setPublishTime(timestamp);
	    track7.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track7);
	    
	    Track track8 = new Track();
	    track8.setTrackName(("Track 8"));
	    track8.setGenre(genre1);
	    track8.setArtist("Artist 8");
	    track8.setUser(user);
	    track8.setPublishTime(timestamp);
	    track8.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track8);
	    
	    Track track9 = new Track();
	    track9.setTrackName(("Track 9"));
	    track9.setGenre(genre1);
	    track9.setArtist("Artist 9");
	    track9.setUser(user);
	    track9.setPublishTime(timestamp);
	    track9.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track9);
	    
	    Track track10 = new Track();
	    track10.setTrackName(("Track 10"));
	    track10.setGenre(genre1);
	    track10.setArtist("Artist 10");
	    track10.setUser(user);
	    track10.setPublishTime(timestamp);
	    track10.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track10);
	    
	    Track track11 = new Track();
	    track11.setTrackName(("Track 11"));
	    track11.setGenre(genre1);
	    track11.setArtist("Artist 11");
	    track11.setUser(user);
	    track11.setPublishTime(timestamp);
	    track11.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track11);
	    
	    Track track12 = new Track();
	    track12.setTrackName(("Track 12"));
	    track12.setGenre(genre1);
	    track12.setArtist("Artist 12");
	    track12.setUser(user2);
	    track12.setPublishTime(timestamp);
	    track12.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track12);
	    
	    Track track13 = new Track();
	    track13.setTrackName(("Trck 13"));
	    track13.setGenre(genre1);
	    track13.setArtist("Artist 13");
	    track13.setUser(user2);
	    track13.setPublishTime(timestamp);
	    track13.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track13);
	    
	    Track track14 = new Track();
	    track14.setTrackName(("Track 14"));
	    track14.setGenre(genre1);
	    track14.setArtist("Artist 14");
	    track14.setUser(user2);
	    track14.setPublishTime(timestamp);
	    track14.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track14);
	    
	    Track track15 = new Track();
	    track15.setTrackName(("Track 15"));
	    track15.setGenre(genre1);
	    track15.setArtist("Artist 15");
	    track15.setUser(user);
	    track15.setPublishTime(timestamp);
	    track15.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track15);
	    
	    Track track16 = new Track();
	    track16.setTrackName(("Track 16"));
	    track16.setGenre(genre1);
	    track16.setArtist("Artist 16");
	    track16.setUser(user);
	    track16.setPublishTime(timestamp);
	    track16.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track16);
	    
	    Track track17 = new Track();
	    track17.setTrackName(("Track 17"));
	    track17.setGenre(genre1);
	    track17.setArtist("Artist 17");
	    track17.setUser(user);
	    track17.setPublishTime(timestamp);
	    track17.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track17);
	    
	    Track track18 = new Track();
	    track18.setTrackName(("Track 18"));
	    track18.setGenre(genre1);
	    track18.setArtist("Artist 18");
	    track18.setUser(user);
	    track18.setPublishTime(timestamp);
	    track18.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track18);
	  /*  
	    Rating rating1 = new Rating();
	    rating1.setUser(user);
	    rating1.setTrack(track10);
	    rating1.setRating(1);
	    rating1Repository.save(rating1);
	    
	    Rating rating2 = new Rating();
	    rating2.setUser(user);
	    rating2.setTrack(track10);
	    rating2.setRating(1);
	    rating1Repository.save(rating2);
	    */
/*	    Rating rating1 = new Rating();
	    rating1.setUser(user);
	    rating1.setTrack(track10);
	    rating1.setRating(1);
	    rating1Repository.save(rating1);
	    
	    Rating rating1 = new Rating();
	    rating1.setUser(user);
	    rating1.setTrack(track10);
	    rating1.setRating(1);
	    rating1Repository.save(rating1);
	    
	    Rating rating1 = new Rating();
	    rating1.setUser(user);
	    rating1.setTrack(track10);
	    rating1.setRating(1);
	    rating1Repository.save(rating1);
	    
	    Rating rating1 = new Rating();
	    rating1.setUser(user);
	    rating1.setTrack(track10);
	    rating1.setRating(1);
	    rating1Repository.save(rating1);
	    
	    Rating rating1 = new Rating();
	    rating1.setUser(user);
	    rating1.setTrack(track10);
	    rating1.setRating(1);
	    rating1Repository.save(rating1);*/
	    
	    
	    List<Track> tracks = new ArrayList<Track>();
	    tracks.add(track2);
	    tracks.add(track1);
	    
	    List<Track> tracks1 = new ArrayList<Track>();
	    tracks1.add(track1);
	    Playlist pl1 = new Playlist();
	    pl1.setName("pl1");
	    pl1.setTracks(tracks);
	    pl1.setUser(user);
	    
	   
	    
	    Playlist pl2 = new Playlist();
	    pl2.setName("pl2");
	    pl2.setTracks(tracks1);
	    pl2.setUser(user); 
	    
	    List<Track> tracks3 = trackService.findByUser(user);
	    Playlist pl3 = new Playlist();
	    pl3.setName("All Tracks");
	    pl3.setTracks(tracks3);
	    pl3.setUser(user); 
	    
	    playlistRepository.save(pl1);
	    playlistRepository.save(pl2);
	    playlistRepository.save(pl3);
	}

}

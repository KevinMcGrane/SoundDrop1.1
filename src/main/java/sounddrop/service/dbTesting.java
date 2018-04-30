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
import sounddrop.model.Post;
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
	private PostService postService;
	
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
		user5.setBio("Hi there!");	
		user5.setRoles(roles);
		userRepository.save(user5);	
		
		User user6 = new User();
		user6.setUsername("user6");
		user6.setPassword(bCryptPasswordEncoder.encode(password2));
		user6.setFname("Stephen");
		user6.setLname("Smith");
		user6.setBio("Love house music!");	
		user6.setRoles(roles);
		userRepository.save(user6);	
		
		User user7 = new User();
		user7.setUsername("user7");
		user7.setPassword(bCryptPasswordEncoder.encode(password2));
		user7.setFname("Mo");
		user7.setLname("Salah");
		user7.setBio("The Egyptian Messi!");	
		user7.setRoles(roles);
		userRepository.save(user7);	
		
		User user8 = new User();
		user8.setUsername("user8");
		user8.setPassword(bCryptPasswordEncoder.encode(password2));
		user8.setFname("Homer");
		user8.setLname("Simpson");
		user8.setBio("DOH!");	
		user8.setRoles(roles);
		userRepository.save(user8);	
		
		User user9 = new User();
		user9.setUsername("user9");
		user9.setPassword(bCryptPasswordEncoder.encode(password2));
		user9.setFname("Donald");
		user9.setLname("Trump");
		user9.setBio("Make America Great!");	
		user9.setRoles(roles);
		userRepository.save(user9);	
		
		User user10 = new User();
		user10.setUsername("user10");
		user10.setPassword(bCryptPasswordEncoder.encode(password2));
		user10.setFname("Phil");
		user10.setLname("Smith");
		user10.setBio("Hi!");	
		user10.setRoles(roles);
		userRepository.save(user10);	
		
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
	    
	    Genre genre4 = new Genre();
	    genre4.setName("Acid House");
	    genreRepository.save(genre4);
	    
	    Genre genre5 = new Genre();
	    genre5.setName("Dubstep");
	    genreRepository.save(genre5);
	    
	    Genre genre6 = new Genre();
	    genre6.setName("Jungle");
	    genreRepository.save(genre6);
	    
	    Genre genre7 = new Genre();
	    genre7.setName("Drum and Bass");
	    genreRepository.save(genre7);
	    
	    Playlist pl1 = new Playlist();
	    pl1.setName("pl1");
	    pl1.setUser(user);
	    
	   Track track1 = new Track();
	    track1.setTrackName(("It's Only Real"));
	    track1.setGenre(genre1);
	    track1.setArtist("Denis Sulta");
	    track1.setUser(user);
	    track1.setPublishTime(timestamp);
	    track1.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	   
	    playlistRepository.save(pl1);
	    List<Playlist> playlists = new ArrayList<Playlist>();
	    playlists.add(pl1);
	    track1.setPlaylists(playlists);
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
	    track3.setTrackName(("Rain"));
	    track3.setGenre(genre1);
	    track3.setArtist("Bicep");
	    track3.setUser(user);
	    track3.setPublishTime(timestamp);
	    track3.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track3);
	    
	    Track track4 = new Track();
	    track4.setTrackName(("Kites"));
	    track4.setGenre(genre1);
	    track4.setArtist("Bicep");
	    track4.setUser(user);
	    track4.setPublishTime(timestamp);
	    track4.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track4);
	    
	    Track track5 = new Track();
	    track5.setTrackName(("Just"));
	    track5.setGenre(genre1);
	    track5.setArtist("Bicep");
	    track5.setUser(user);
	    track5.setPublishTime(timestamp);
	    track5.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track5);
	    
	    Track track6 = new Track();
	    track6.setTrackName(("Dahlia"));
	    track6.setGenre(genre1);
	    track6.setArtist("Bicep");
	    track6.setUser(user);
	    track6.setPublishTime(timestamp);
	    track6.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track6);
	    
	    Track track7 = new Track();
	    track7.setTrackName(("Let You go"));
	    track7.setGenre(genre1);
	    track7.setArtist("Bicep");
	    track7.setUser(user);
	    track7.setPublishTime(timestamp);
	    track7.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track7);
	    
	    Track track8 = new Track();
	    track8.setTrackName(("Liberate"));
	    track8.setGenre(genre1);
	    track8.setArtist("Eric Prydz");
	    track8.setUser(user);
	    track8.setPublishTime(timestamp);
	    track8.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track8);
	    
	    Track track9 = new Track();
	    track9.setTrackName(("In the reds"));
	    track9.setGenre(genre1);
	    track9.setArtist("Eric Prydz");
	    track9.setUser(user);
	    track9.setPublishTime(timestamp);
	    track9.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track9);
	    
	    Track track10 = new Track();
	    track10.setTrackName(("Pjanoo"));
	    track10.setGenre(genre1);
	    track10.setArtist("Eric Prydz");
	    track10.setUser(user);
	    track10.setPublishTime(timestamp);
	    track10.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track10);
	    
	    Track track11 = new Track();
	    track11.setTrackName(("Call on me"));
	    track11.setGenre(genre1);
	    track11.setArtist("Eric Prydz");
	    track11.setUser(user2);
	    track11.setPublishTime(timestamp);
	    track11.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track11);
	    
	    Track track12 = new Track();
	    track12.setTrackName(("New Order"));
	    track12.setGenre(genre1);
	    track12.setArtist("Blue Monday");
	    track12.setUser(user2);
	    track12.setPublishTime(timestamp);
	    track12.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track12);
	    
	    Track track13 = new Track();
	    track13.setTrackName(("Firestarter"));
	    track13.setGenre(genre1);
	    track13.setArtist("Prodigy");
	    track13.setUser(user2);
	    track13.setPublishTime(timestamp);
	    track13.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track13);
	    
	    Track track14 = new Track();
	    track14.setTrackName(("Out of space"));
	    track14.setGenre(genre1);
	    track14.setArtist("Prodigy");
	    track14.setUser(user2);
	    track14.setPublishTime(timestamp);
	    track14.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track14);
	    
	    Track track15 = new Track();
	    track15.setTrackName(("No Good to Me"));
	    track15.setGenre(genre1);
	    track15.setArtist("Prodigy");
	    track15.setUser(user2);
	    track15.setPublishTime(timestamp);
	    track15.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track15);
	    
	    Track track16 = new Track();
	    track16.setTrackName(("Circles"));
	    track16.setGenre(genre1);
	    track16.setArtist("George Fitz");
	    track16.setUser(user2);
	    track16.setPublishTime(timestamp);
	    track16.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track16);
	    
	    Track track17 = new Track();
	    track17.setTrackName(("The Bells"));
	    track17.setGenre(genre1);
	    track17.setArtist("Jeff Mills");
	    track17.setUser(user2);
	    track17.setPublishTime(timestamp);
	    track17.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track17);
	    
	    Track track18 = new Track();
	    track18.setTrackName(("Refractured"));
	    track18.setGenre(genre1);
	    track18.setArtist("Sahsa");
	    track18.setUser(user2);
	    track18.setPublishTime(timestamp);
	    track18.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track18);
	    
	    Track track19 = new Track();
	    track19.setTrackName(("Lalala"));
	    track19.setGenre(genre1);
	    track19.setArtist("Kylie Minogue");
	    track19.setUser(user2);
	    track19.setPublishTime(timestamp);
	    track19.setFileName("1521219951901-Denis_Sulta_-_It's_Only_Real.mp3");
	    trackRepository.save(track19);
	    
	   
	    
	    Post post = new Post();
	    post.setTrack(track1);
	    postService.save(null, track1);
	    
	    Post post1 = new Post();
	    post1.setTrack(track2);
	    postService.save(null, track2);
	    
	    Post post2 = new Post();
	    post2.setTrack(track3);
	    postService.save(null, track3);
	    
	    Post post3 = new Post();
	    post3.setTrack(track4);
	    postService.save(null, track4);
	    
	    Post post4 = new Post();
	    post4.setTrack(track5);
	    postService.save(null, track5);
	    
	    Post post5 = new Post();
	    post5.setTrack(track6);
	    postService.save(null, track6);
	    
	    Post post6 = new Post();
	    post6.setTrack(track7);
	    postService.save(null, track7);
	    
	    Post post7 = new Post();
	    post7.setTrack(track8);
	    postService.save(null, track8);
	    
	    Post post8 = new Post();
	    post8.setTrack(track9);
	    postService.save(null, track9);
	    
	    Post post9 = new Post();
	    post9.setTrack(track10);
	    postService.save(null, track10);
	    
	    Post post10 = new Post();
	    post10.setTrack(track11);
	    postService.save(null, track11);
	    
	    Post post11 = new Post();
	    post11.setTrack(track12);
	    postService.save(null, track12);
	    
	    Post post12 = new Post();
	    post12.setTrack(track13);
	    postService.save(null, track13);
	   
	    Post post13 = new Post();
	    post13.setTrack(track14);
	    postService.save(null,track14);
	    
	    Post post14 = new Post();
	    post14.setTrack(track15);
	    postService.save(null, track15);
	    
	    Post post15 = new Post();
	    post15.setTrack(track16);
	    postService.save(null, track16);
	    
	    Post post16 = new Post();
	    post16.setTrack(track17);
	    postService.save(null, track17);
	    
	    Post post17 = new Post();
	    post17.setTrack(track18);
	    postService.save(null, track18);
	    
	    
	   
	    
	    Set<Track> tracks = new HashSet<Track>();
	    tracks.add(track2);
	    tracks.add(track1);
	    
	    Set<Track> tracks1 = new HashSet<Track>();
	    tracks1.add(track1);
	   
	   
	    
	    Playlist pl2 = new Playlist();
	    pl2.setName("pl2");
	    pl2.setUser(user); 
	    
	    Set<Track> tracks3 = trackService.findByUser(user);
	    Playlist pl3 = new Playlist();
	    pl3.setName("AllTracks");
	    pl3.setTracks(tracks3);
	    pl3.setUser(user); 
	    
	    
	    
	    playlistRepository.save(pl2);
	    playlistRepository.save(pl3);
	}

}

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
		

//
//		Role roleUser = new Role();
//		roleUser.setName("ROLE_USER");
//		roleRepository.save(roleUser);
//
//		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//		grantedAuthorities.add(new SimpleGrantedAuthority(roleUser.getName()));
//
//		User user = new User();
//		String password = "test";
//		user.setUsername("kevin97");
//		user.setPassword(bCryptPasswordEncoder.encode(password));
//		user.setFname("Kevin");
//		user.setLname("McGrane");
//		user.setBio("Have a great day!");
//		
//		
//		
//		HashSet<Role> roles = new HashSet<>();
//		roles.add(roleUser);
//		user.setRoles(roles);
//		userRepository.save(user);
//
//		
//
//		HashSet<User> requests = new HashSet<>();
//		requests.add(user);
//		User user2 = new User();
//		String password2 = "test";
//		user2.setUsername("user2");
//		user2.setPassword(bCryptPasswordEncoder.encode(password2));
//		user2.setFname("Brian");
//		user2.setLname("MacCourt");
//		user2.setBio("Hi there!");
//	
//		
//		user2.setRoles(roles);
//		userRepository.save(user2);
//		
//		
//		
//		User user3 = new User();
//		user3.setUsername("user3");
//		user3.setPassword(bCryptPasswordEncoder.encode(password2));
//		user3.setFname("John");
//		user3.setLname("Reilly");
//		user3.setBio("Hi there!")	;	
//		user3.setRoles(roles);
//		userRepository.save(user3);
//		
//		User user4 = new User();
//		user4.setUsername("user4");
//		user4.setPassword(bCryptPasswordEncoder.encode(password2));
//		user4.setFname("Joe");
//		user4.setLname("Bloggs");
//		user4.setBio("Hi there!");
//		user4.setRoles(roles);
//		userRepository.save(user4);
//		
//		User user5 = new User();
//		user5.setUsername("user5");
//		user5.setPassword(bCryptPasswordEncoder.encode(password2));
//		user5.setFname("John");
//		user5.setLname("Bloggs");
//		user5.setBio("Hi there!");	
//		user5.setRoles(roles);
//		userRepository.save(user5);	
//		
//		User user6 = new User();
//		user6.setUsername("user6");
//		user6.setPassword(bCryptPasswordEncoder.encode(password2));
//		user6.setFname("Stephen");
//		user6.setLname("Smith");
//		user6.setBio("Love house music!");	
//		user6.setRoles(roles);
//		userRepository.save(user6);	
//		
//		User user7 = new User();
//		user7.setUsername("user7");
//		user7.setPassword(bCryptPasswordEncoder.encode(password2));
//		user7.setFname("Mo");
//		user7.setLname("Salah");
//		user7.setBio("The Egyptian Messi!");	
//		user7.setRoles(roles);
//		userRepository.save(user7);	
//		
//		User user8 = new User();
//		user8.setUsername("user8");
//		user8.setPassword(bCryptPasswordEncoder.encode(password2));
//		user8.setFname("Homer");
//		user8.setLname("Simpson");
//		user8.setBio("DOH!");	
//		user8.setRoles(roles);
//		userRepository.save(user8);	
//		
//		User user9 = new User();
//		user9.setUsername("user9");
//		user9.setPassword(bCryptPasswordEncoder.encode(password2));
//		user9.setFname("Donald");
//		user9.setLname("Trump");
//		user9.setBio("Make America Great!");	
//		user9.setRoles(roles);
//		userRepository.save(user9);	
//		
//		User user10 = new User();
//		user10.setUsername("user10");
//		user10.setPassword(bCryptPasswordEncoder.encode(password2));
//		user10.setFname("Phil");
//		user10.setLname("Smith");
//		user10.setBio("Hi!");	
//		user10.setRoles(roles);
//		userRepository.save(user10);	
//		
//	
//
//	    Genre genre = new Genre();
//	    genre.setName("Techno");
//	    genreRepository.save(genre);
//	    
//	    Genre genre1 = new Genre();
//	    genre1.setName("House");
//	    genreRepository.save(genre1);
//	    
//	    Genre genre2 = new Genre();
//	    genre2.setName("Tech House");
//	    genreRepository.save(genre2);
//	    
//	    Genre genre3 = new Genre();
//	    genre3.setName("Trance");
//	    genreRepository.save(genre3);
//	    
//	    Genre genre4 = new Genre();
//	    genre4.setName("Acid House");
//	    genreRepository.save(genre4);
//	    
//	    Genre genre5 = new Genre();
//	    genre5.setName("Dubstep");
//	    genreRepository.save(genre5);
//	    
//	    Genre genre6 = new Genre();
//	    genre6.setName("Jungle");
//	    genreRepository.save(genre6);
//	    
//	    Genre genre7 = new Genre();
//	    genre7.setName("Drum and Bass");
//	    genreRepository.save(genre7);
//	    
//	 
//	   
//	    
//	    
	    
	   
	    
	   
	   
	   
	    
	}

}

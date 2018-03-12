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
import sounddrop.model.PostText;
import sounddrop.model.Role;
import sounddrop.model.User;
import sounddrop.repository.GenreRepository;
import sounddrop.repository.PostTextRepository;
import sounddrop.repository.RoleRepository;
import sounddrop.repository.UserRepository;

@Transactional
@Service
public class dbTesting {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PostTextRepository postTextRepository;
	
	@Autowired
	private GenreRepository genreRepository;

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
		user2.setUsername("brian98");
		user2.setPassword(bCryptPasswordEncoder.encode(password2));
		user2.setFname("Brian");
		user2.setLname("MacCourt");
		user2.setBio("Hi there!");
	
		
		
		
		
		user2.setRoles(roles);
		userRepository.save(user2);
		
		
		
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
	}

}

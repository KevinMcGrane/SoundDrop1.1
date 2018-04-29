package sounddrop.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sounddrop.model.ProfilePic;
import sounddrop.model.User;
import sounddrop.repository.ProfilePicRepository;
import sounddrop.repository.UserRepository;

@Service
public class ProfilePicServiceImpl implements ProfilePicService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProfilePicRepository profilePicRepository;
	
	@Autowired
	UserService userService;
	
	//Save profile pic details to MySql
	@Override
	public void save(User user, String fileName) {
		ProfilePic newPic = new ProfilePic();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        newPic.setFileName(fileName);
        newPic.setPublishTime(timestamp);
		newPic.setUser(user);
		profilePicRepository.save(newPic);	
		user.setProfilePic(newPic);
		userService.update(user);
	}

}

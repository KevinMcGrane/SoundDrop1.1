package sounddrop.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sounddrop.model.PostText;
import sounddrop.model.Track;
import sounddrop.model.User;
import sounddrop.repository.TrackRepository;
import sounddrop.repository.UserRepository;

@Service
public class TrackServiceImpl implements TrackService{

    @Autowired
	UserRepository userRepository;
    
    @Autowired
	TrackRepository trackRepository;
	
	@Override
	public void save(String track, String name, String fileName) {
		Track newTrack = new Track();
		User user = userRepository.findByUsername(name);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        newTrack.setTrackName(track);
        newTrack.setFileName(fileName);
        newTrack.setPublishTime(timestamp);
		newTrack.setUser(user);
		trackRepository.save(newTrack);		
	}
	
	 @Override
		public List<Track> getAllTrack() {
	    	List<Track> trackList = trackRepository.findAll();
	    	
	    	return trackList;
		}

}

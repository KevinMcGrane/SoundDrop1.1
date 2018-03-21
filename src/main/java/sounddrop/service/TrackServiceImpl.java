package sounddrop.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sounddrop.model.Genre;
import sounddrop.model.Playlist;
import sounddrop.model.PostText;
import sounddrop.model.Track;
import sounddrop.model.User;
import sounddrop.repository.TrackRepository;
import sounddrop.repository.UserRepository;

@Service
public class TrackServiceImpl implements TrackService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	TrackRepository trackRepository;

	@Override
	public void save(String trackName, String name, String artist, String fileName, Genre genre) {
		Track newTrack = new Track();
		User user = userRepository.findByUsername(name);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		newTrack.setTrackName(trackName);
		newTrack.setFileName(fileName);
		newTrack.setArtist(artist);
		newTrack.setPublishTime(timestamp);
		newTrack.setUser(user);
		newTrack.setGenre(genre);
		trackRepository.save(newTrack);
	}
	
	
	@Override
	public List<Track> getAllTrack() {
		List<Track> trackList = trackRepository.findAll();

		return trackList;
	}

	@Override
	public List<Track> getTrackFeed(Set<User> friends, User user) {
		List<Track> trackList = trackRepository.findByUserIn(friends);
		List<Track> myTracks = trackRepository.findByUser(user);
		List<Track> newList = new ArrayList<Track>();
    	newList.addAll(trackList);
    	newList.addAll(myTracks);
    	class OutcomeAscComparator implements Comparator<Track>
	    {
	        public int compare(Track left, Track right) {
	            return right.getPublishTime().compareTo(left.getPublishTime());
	        }
	    }
    	Collections.sort(newList, new OutcomeAscComparator());

		return newList;
	}

	@Override
	public void delete(Track track) {
		trackRepository.delete(track);
	}

	@Override
	public Track findByTrackId(long id) {
		return trackRepository.findById(id);
	}
	
	@Override
	public void addTrackToPlaylist(Track track, Playlist pl) {
		
	}


	@Override
	public void update(long id) {
		
			Track track = findByTrackId(id);
			track.setComments(track.getComments());
			trackRepository.save(track);

		
	}

}

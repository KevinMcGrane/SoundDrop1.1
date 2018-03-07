package sounddrop.service;

import java.util.List;
import java.util.Set;

import sounddrop.model.PostText;
import sounddrop.model.Track;
import sounddrop.model.User;

public interface TrackService {
	public void save (String track, String name, String fileName);
	public List<Track> getAllTrack();
	public List<Track> getFriendsTracks(Set<User> friends);

}

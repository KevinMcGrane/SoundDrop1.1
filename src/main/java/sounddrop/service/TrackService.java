package sounddrop.service;

import java.util.List;
import java.util.Set;

import sounddrop.model.Genre;
import sounddrop.model.Playlist;
import sounddrop.model.Track;
import sounddrop.model.User;

public interface TrackService {
	public void save (String trackName, String name, String artist, String fileName, Genre genre);
	public List<Track> getAllTrack();
	public List<Track> getTrackFeed(Set<User> friends, User user);
	public void delete(Track track);
	public Track findByTrackId(long id);
	public void update(long id);
	public void addTrackToPlaylist(Track track, Playlist pl);

}

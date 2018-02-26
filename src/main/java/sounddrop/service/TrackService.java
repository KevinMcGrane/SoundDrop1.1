package sounddrop.service;

import java.util.List;

import sounddrop.model.PostText;
import sounddrop.model.Track;

public interface TrackService {
	public void save (String track, String name, String fileName);
	public List<Track> getAllTrack();

}

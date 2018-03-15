package sounddrop.service;

import sounddrop.model.Playlist;
import sounddrop.model.User;

public interface PlaylistService {

	void save(Playlist playlist, User user);

}

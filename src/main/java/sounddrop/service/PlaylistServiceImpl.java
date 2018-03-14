package sounddrop.service;

import org.springframework.beans.factory.annotation.Autowired;

import sounddrop.model.Playlist;
import sounddrop.repository.PlaylistRepository;

public class PlaylistServiceImpl implements PlaylistService{
	@Autowired
	PlaylistRepository playlistRepository;
	@Override
	public void save(String name) {
		Playlist newPlaylist = new Playlist();
		playlistRepository.save(newPlaylist);
	}

}

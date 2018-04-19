package sounddrop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sounddrop.model.Playlist;
import sounddrop.model.User;
import sounddrop.repository.PlaylistRepository;

@Service
public class PlaylistServiceImpl implements PlaylistService{
	@Autowired
	PlaylistRepository playlistRepository;
	
	//Save playlist
	@Override
	public void save(Playlist playlist, User user) {
		playlist.setName(playlist.getName());
		playlist.setUser(user);
		playlist.setTracks(playlist.getTracks());
		playlistRepository.save(playlist);
	}
	
	//Find playlist by user
	@Override
	public List<Playlist> findByUser(User user){
		return playlistRepository.findByUser(user);
	}
	
	//Find playlist by name
	@Override
	public Playlist findByName(String name) {
		return playlistRepository.findByName(name);
	}

}

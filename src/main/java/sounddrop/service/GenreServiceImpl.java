package sounddrop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sounddrop.model.Genre;
import sounddrop.repository.GenreRepository;

@Service
public class GenreServiceImpl implements GenreService {
	@Autowired
	GenreRepository genreRepository;

	@Override
	public void save(String name) {
		Genre newGenre = new Genre();
		newGenre.setName(name);
		genreRepository.save(newGenre);
		
	}
	
	@Override
	public List<Genre> getAllGenre(){
		return genreRepository.findAll();
	}
	
	@Override
	public boolean containsName(final List<Genre> list, final String name){
	    return list.stream().filter(o -> o.getName().equals(name)).findFirst().isPresent();
	}

}

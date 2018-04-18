package sounddrop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sounddrop.model.Rating;
import sounddrop.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService{
	@Autowired
	RatingRepository ratingRepository;

	@Override
	public void save(Rating rating) {
		ratingRepository.save(rating);
	}
	
}

package sounddrop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sounddrop.model.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {

}

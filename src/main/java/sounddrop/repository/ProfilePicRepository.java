package sounddrop.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import sounddrop.model.ProfilePic;
import sounddrop.model.Track;
import sounddrop.model.User;

public interface ProfilePicRepository extends JpaRepository<ProfilePic, Long>{


}

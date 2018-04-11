package sounddrop.repository;

import sounddrop.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    
    List<User> findUserByLname(String lname);
    
    List<User> findFriendsByLname(String lname);

    	
}

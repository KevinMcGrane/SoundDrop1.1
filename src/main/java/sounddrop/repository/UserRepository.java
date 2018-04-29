package sounddrop.repository;

import sounddrop.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    
    List<User> findUserByLname(String lname);
    
    List<User> findFriendsByLname(String lname);

    	
}

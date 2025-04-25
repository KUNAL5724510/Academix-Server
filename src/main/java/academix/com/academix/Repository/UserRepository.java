package academix.com.academix.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import academix.com.academix.Entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findByEmail(String email);

    Optional<Users> findByRole(String string);
  

}

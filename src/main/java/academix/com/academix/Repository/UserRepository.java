package academix.com.academix.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import academix.com.academix.Entity.Principal;

@Repository
public interface UserRepository extends JpaRepository<Principal, Integer> {

    Optional<Principal> findByEmail(String email);
  

}

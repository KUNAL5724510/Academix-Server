package academix.com.academix.Repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import academix.com.academix.Entity.Teachers;

import org.springframework.data.jpa.repository.JpaRepository;

import academix.com.academix.Entity.Users;


@Repository
public interface TeacherRepository extends JpaRepository<Teachers, Integer> {

    
    

}

package academix.com.academix.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academix.com.academix.Repository.UserRepository;
import academix.com.academix.Repository.TeacherRepository;
import academix.com.academix.Entity.Users;
import academix.com.academix.Entity.Teachers;

@RestController
@RequestMapping("/Teacher")
@CrossOrigin(origins = "http://localhost:3000")
public class CTeacher {

    @Autowired
    private TeacherRepository cteacher;  // for teacher-specific data (if needed)

    @Autowired
    private UserRepository cuser;        // ✅ FIXED: User repository for login

    @PostMapping("/login")
    public String teacherLogin(@RequestBody Users udata) {
        String email = udata.getEmail();
        String password = udata.getPassword();
    
        Optional<Users> userOptional = cuser.findByEmail(email);
    
        if (userOptional.isPresent()) {
            Users userInDb = userOptional.get();
    
            if ("Teacher".equalsIgnoreCase(userInDb.getRole())) {
                if (userInDb.getPassword().equals(password)) {
                    return "Login Successful";
                } else {
                    return "Invalid Password";
                }
            } else {
                return "User is not a Teacher";
            }
        } else {
            return "Email not found";
        }


        
    }
    
}

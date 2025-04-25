package academix.com.academix.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academix.com.academix.Repository.UserRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import academix.com.academix.Entity.Users;


@RestController
@RequestMapping("/Principal")
@CrossOrigin(origins = "http://localhost:3000")
public class CUsers {
     
    @Autowired
     private UserRepository cuser;

     @PostMapping("/Register")      
     public String PrincipalRegister(@RequestBody Users pdata ) {
         pdata.setRole("Principal");
         cuser.save(pdata);
         return "Users Registered Successfully";
     }

     @RequestMapping("/PLogin")
        public String PrincipalLogin(@RequestBody Users pdata) {
            String email = pdata.getEmail();
            String password = pdata.getPassword();

            Optional<Users> usermail = cuser.findByEmail(email);

            if (usermail.isPresent()) {
                Users Users = usermail.get();

                if("Users".equalsIgnoreCase(Users.getRole()))
                 {
                    if (Users.getPassword().equals(password)) {
                        return "Login Successful";
                    } else {
                        return "Invalid Password";
                    }
                } else {
                    return "Invalid Role";
                }
                
            } else {
                return "Email not found";
            }
        }

    @PostMapping("/register-teacher")
    public String registerTeacher(@RequestBody Users teacherdetails) {
        // Save the teacher to the database
        Optional<Users> existingUser = cuser.findByEmail(teacherdetails.getEmail());
        if (existingUser.isPresent()) {
            Users existingUserDetails = existingUser.get();
            existingUserDetails.setRole("Teacher");
            cuser.save(existingUserDetails); // Update the existing user with the new role
            return "Email already exists for Teacher registration";
        }else{
            teacherdetails.setRole("Teacher");
            cuser.save(teacherdetails); // Set the role to "Teacher"
            return "Teacher registered successfully";
        }
        
        
    }
     
}

package academix.com.academix.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academix.com.academix.Repository.UserRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import academix.com.academix.Entity.Principal;


@RestController
@RequestMapping("/principal")
public class CPrincipal {
     
    @Autowired
     private UserRepository cuser;

     @PostMapping("/Register")      
     public String PrincipalRegister(@RequestBody Principal pdata ) {
         cuser.save(pdata);
         return "Principal Registered Successfully";
     }

     @RequestMapping("/PLogin")
        public String PrincipalLogin(@RequestBody Principal pdata) {
            String email = pdata.getEmail();
            String password = pdata.getPassword();

            Optional<Principal> usermail = cuser.findByEmail(email);

            if (usermail.isPresent()) {
                Principal user = usermail.get();

                if("PRINCIPAL".equalsIgnoreCase(user.getRole()))
                 {
                    if (user.getPassword().equals(password)) {
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
     
}

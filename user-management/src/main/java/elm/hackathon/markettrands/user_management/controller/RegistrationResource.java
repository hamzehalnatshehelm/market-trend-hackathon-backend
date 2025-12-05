package elm.hackathon.markettrands.user_management.controller;

import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
public class RegistrationResource {

    @GetMapping("/")
    public ResponseEntity<String> registerUser() {
        return new ResponseEntity<>("Registered Successfully", HttpStatus.CREATED);
    }
}

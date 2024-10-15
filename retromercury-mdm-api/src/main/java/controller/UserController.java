package controller;

import dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @RequestMapping("/createUser")
    public ResponseEntity<UserDto> createUser(@RequestParam String name) {
        return null;
    }
}

package com.ekibiina.ekibiina.api.controllers.users;

import com.ekibiina.ekibiina.api.controllers.users.data.User;
import com.ekibiina.ekibiina.api.service.FirebaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    FirebaseUserService firebaseUserService;
    // User-related endpoints will be defined here
    @GetMapping("/list")
    public String getUser() {
        // Retrieve the UID from the SecurityContext
        String uid = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "Authenticated user UID: " + uid;
    }

    @PostMapping("/create")
    public String createUser(@RequestBody User.Req req) throws Exception {
        firebaseUserService.createUser(req.email(), req.password(), req.displayName(), req.roleNames());
        return "User created successfully";
    }
}

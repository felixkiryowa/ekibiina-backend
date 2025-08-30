package com.ekibiina.ekibiina.api.controllers.users;

import com.ekibiina.ekibiina.api.controllers.users.data.UserCmd;
import com.ekibiina.ekibiina.api.service.FirebaseUserService;
import com.google.firebase.auth.ExportedUserRecord;
import com.google.firebase.auth.UserRecord;
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
    public Iterable<ExportedUserRecord>  getUser() throws Exception {
        // Retrieve the UID from the SecurityContext
        String uid = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        System.out.println("Authenticated user UID: " + uid);

        return firebaseUserService.listAllUsers();
    }

    @PostMapping("/create")
    public UserRecord createUser(@RequestBody UserCmd.Req req) throws Exception {
        System.out.println("REQUEST " + req);
      return  firebaseUserService.createUser(req.email(), req.password(),
              req.displayName(), req.roleNames());
    }
}

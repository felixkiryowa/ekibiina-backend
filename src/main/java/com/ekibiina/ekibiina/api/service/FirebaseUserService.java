package com.ekibiina.ekibiina.api.service;

import com.ekibiina.ekibiina.api.controllers.users.data.UserCmd;
import com.ekibiina.ekibiina.api.entities.Role;
import com.ekibiina.ekibiina.api.entities.Sacco;
import com.ekibiina.ekibiina.api.entities.User;
import com.ekibiina.ekibiina.api.repository.RoleRepository;
import com.ekibiina.ekibiina.api.repository.UserRepository;
import com.ekibiina.ekibiina.exceptions.BusinessException;
import com.google.firebase.auth.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FirebaseUserService {

    @Autowired
    UserRepository userRepository;
    @Autowired RoleRepository roleRepository;

    public UserRecord createUser(UserCmd.Req req) throws Exception {
        System.out.println("Creating user with email: " + req.email() + ", displayName: " + req.displayName() + ", roles: " + req.roleNames());
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(req.email())
                .setPassword(req.password())
                .setDisplayName(req.displayName());

        UserRecord firebaseUser = null;
        try {
            firebaseUser = FirebaseAuth.getInstance().createUser(request);
        } catch (FirebaseAuthException e) {
            System.out.println("Error creating user: " + e.getMessage());
            throw new BusinessException(e.getErrorCode(), "FIREBASE_USER_CREATION_FAILED", "Error creating user: " + e.getMessage());
        }
        System.out.println("Created user: " + firebaseUser.getUid());
        // Fetch roles from the database
        Set<Role> roles = roleRepository.findByNameIn(req.roleNames());

        System.out.println(roles);
        // Create a new user
        User newUser = new User();
        newUser.setFirebaseUid(firebaseUser.getUid());
        newUser.setUsername(req.email());
        newUser.setName(req.displayName());
        newUser.setFirebaseUid(firebaseUser.getUid());
        newUser.setRoles(roles);
        userRepository.save(newUser);

        return  FirebaseAuth.getInstance().getUser(firebaseUser.getUid());

    }

    public UserRecord getUserByEmail(String email) throws Exception {
        return FirebaseAuth.getInstance().getUserByEmail(email);
    }

    public void deleteUser(String uid) throws Exception {
        FirebaseAuth.getInstance().deleteUser(uid);
    }

    // Add more user management methods as needed
    public UserRecord getUserById(String uid) throws Exception {
        return FirebaseAuth.getInstance().getUser(uid);
    }

    public UserRecord updateUser(String uid, String email, String displayName) throws Exception {
        UserRecord.UpdateRequest request = new UserRecord.UpdateRequest(uid)
                .setEmail(email)
                .setDisplayName(displayName);
        return FirebaseAuth.getInstance().updateUser(request);
    }

    // List all users (with pagination support)
    public Iterable<ExportedUserRecord> listAllUsers() throws Exception {
        return FirebaseAuth.getInstance().listUsers(null).iterateAll();
    }

    public String getUserAuthToken(String uid) throws Exception {
        return FirebaseAuth.getInstance().createCustomToken(uid);
    }

    // verify token
    public String verifyToken(String token) throws Exception {
        // idToken comes from the client app (shown above)
        FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
        String uid = decodedToken.getUid();
        return uid;
    }

}

package com.ekibiina.ekibiina.api.service;

import com.ekibiina.ekibiina.api.entities.Role;
import com.ekibiina.ekibiina.api.entities.UserEntity;
import com.ekibiina.ekibiina.api.repository.RoleRepository;
import com.ekibiina.ekibiina.api.repository.UserRepository;
import com.google.firebase.auth.ExportedUserRecord;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.UserRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FirebaseUserService {

    @Autowired
    UserRepository userRepository;
    @Autowired RoleRepository roleRepository;

    public UserRecord createUser(String email, String password, String displayName, Set<String> roleNames) throws Exception {
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(email)
                .setPassword(password)
                .setDisplayName(displayName);

        var firebaseUser =  FirebaseAuth.getInstance().createUser(request);
        // Fetch roles from the database
        Set<Role> roles = roleRepository.findByNameIn(roleNames);
        // Create a new user
        UserEntity newUser = new UserEntity();
        newUser.setUuid(firebaseUser.getUid());
        newUser.setEmail(email);
        newUser.setName(displayName);
        newUser.setRoles(roles);
        userRepository.save(newUser);

        return FirebaseAuth.getInstance().createUser(request);
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

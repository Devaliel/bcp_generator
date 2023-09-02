package com.example.bcp_generator.Service;

import com.example.bcp_generator.Model.UserModel;
import com.example.bcp_generator.Repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DefaultUserService {
    private final UserRepository userRepository;

    @Autowired
    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void createDefaultUsers() {
        createUser("Kennie K M Mandolang ST", "password1", "kennie@example.com");
        createUser("Victor Maukar", "password2", "victor@example.com");
        createUser("Leonard P Polandos SKom", "password3", "leonard@example.com");
        createUser("Zussana Korompis SKom", "password4", "zussana@example.com");
        createUser("Nariva Wagey SKom", "password5", "nariva@example.com");
    }

    private void createUser(String username, String password, String email) {
        UserModel user = new UserModel();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        // Set other user properties as needed
        userRepository.save(user);
    }
}




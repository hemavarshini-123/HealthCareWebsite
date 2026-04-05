package crud.healthcare.Service;

import crud.healthcare.Model.User;
import crud.healthcare.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public String register(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return "Email already exists!";
        }
        userRepository.save(user);
        return "Registered successfully";
    }


    public String login(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            if (optionalUser.get().getPassword().equals(password)) {
                return "Logged in successfully";
            } else {
                return "Invalid login";
            }
        } else {
            return "Invalid login";
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}


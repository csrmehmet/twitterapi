package Service;

import Entity.User;
import Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User register(User user) {
        Optional<User> existUser = userRepository.findByUsername(user.getUsername());
        if (existUser.isPresent()){
            throw new RuntimeException("Username Already Exist");

        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public String login(String username, String password) {
        User user = userRepository.findByUsername(username).orElseThrow(()->
            new RuntimeException("user not found"));
        if (passwordEncoder.matches(password,user.getPassword())){
            return "x";
        }
        else {
            throw new RuntimeException("Invalid");
        }
    }
}

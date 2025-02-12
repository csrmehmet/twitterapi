package Service;

import Entity.User;
import Repository.UserRepository;

public interface AuthService {
    User register (User user);
    String login (String username,String password);
}

package ejb;

import entities.UserEntity;

/**
 * Created by carlmccann2 on 16/06/2017.
 */
public interface UserService {
    UserEntity getUser(String username, String password);
    void addUser(UserEntity user);
}

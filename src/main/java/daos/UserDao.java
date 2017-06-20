package daos;

import entities.UserEntity;

/**
 * Created by carlmccann2 on 16/06/2017.
 */
public interface UserDao {
    UserEntity getUser(String username, String password);

    void addUser(UserEntity user);
}

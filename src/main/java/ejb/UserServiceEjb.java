package ejb;

import daos.UserDao;
import entities.UserEntity;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 * Created by carlmccann2 on 16/06/2017.
 */
@Stateless
@Local
public class UserServiceEjb implements UserService {
    @EJB
    private UserDao userDao;

    @Override
    public UserEntity getUser(String username, String password) {
        System.out.println("UserService.getUser");
        return userDao.getUser(username, password);
    }

    @Override
    public void addUser(UserEntity user) {
        System.out.println("UserService.addUser");
        userDao.addUser(user);
    }
}

package edu.just.daoImp;

import edu.just.dao.HelloWorldDAO;
import edu.just.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 2016/5/15.
 */
@Repository
public class HelloWorldDAOImp implements HelloWorldDAO {
    public List<User> selectAll() {
        List<User> users = new ArrayList<User>();
        User user = new User();
        user.setId(1);
        User user1 = new User();
        user1.setId(2);
        users.add(user);
        users.add(user1);
        return users;
    }
}

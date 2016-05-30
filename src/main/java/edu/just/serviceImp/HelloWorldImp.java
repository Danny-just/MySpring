package edu.just.serviceImp;

import edu.just.dao.HelloWorldDAO;
import edu.just.service.HelloWorldService;
import edu.just.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hp on 2016/5/15.
 */
@Service
public class HelloWorldImp implements HelloWorldService {
    @Autowired
    private HelloWorldDAO helloWorldDAO;

    public List<User> selectAll() {
        return helloWorldDAO.selectAll();
    }
}

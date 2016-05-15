package edu.just.controller;

import edu.just.model.User;
import edu.just.service.HelloWorldService;
import edu.just.serviceImp.HelloWorldImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hp on 2016/5/15.
 */
@RestController
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json")
    public List<User> Hello() {

        return helloWorldService.selectAll();
    }
}

package com.xwiggy.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xwiggy.food.dao.UserDaoImpl;
import com.xwiggy.food.model.Login;
import com.xwiggy.food.model.User;
import com.xwiggy.food.utility.StrongAES;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private UserDaoImpl userDao;

    @RequestMapping("/login")
    public Login showLogin() {
        return new Login();
    }

    @PostMapping("/login")
    public User loginProcess(@RequestBody Login login, Model model) {
        User user = null;
        user = userDao.validateUser(login);
        if (user != null)
            user.setPassword(null);
        return user;
    }

    @RequestMapping("/xx")
    private String xx() {
        return new StrongAES().encrypt("");
    }

}

package com.example.SpringWebApplication.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(getClass());


//    @RequestMapping("/login")
//    public String login() {
//        return "login";
//    }

    @RequestMapping("login")
//    request parm used to get values such as localhost:8080/login?name=Mayank
//    Model helps the Model in MVC framework
//    it automatically updates the mvc so that jsp can use values passed to it
    public String login(@RequestParam String name, ModelMap model) {
        model.put("name", name);
        logger.debug("Put something in model");
        return "login";
    }
}

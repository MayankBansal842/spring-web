package com.example.SpringWebApplication.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final AuthenticationService authenticationService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

//    @RequestMapping("/login")
//    public String login() {
//        return "login";
//    }


//    request parm used to get values such as localhost:8080/login?name=Mayank
//    Model helps the Model in MVC framework
//    it automatically updates the mvc so that jsp can use values passed to it
    @RequestMapping("login")
    public String login(@RequestParam String name, ModelMap model) {
        model.put("name", name);
        logger.debug("Put something in model");
        return "login";
    }


//    now we will be using form in a jsp to send data
//    this handles both the get and post requests i.e @RequestMapping("login-form")
    @RequestMapping(value = "login-form", method = RequestMethod.GET)
    public String goToLoginForm() {
        return "login-form";
    }

    @RequestMapping(value = "login-form", method = RequestMethod.POST)
    public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
        model.put("name", name);
        model.put("password", password);
        if (authenticationService.authenticate(name, password)) {
            return "welcome";
        } else {
            return "login-form";
        }
    }


}

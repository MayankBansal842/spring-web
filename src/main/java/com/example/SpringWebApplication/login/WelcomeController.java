package com.example.SpringWebApplication.login;

import org.springframework.boot.actuate.endpoint.SecurityContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
//SessioAtttributes annotation helps the attribute "name" to be stored longer rather than just model map which only available for one request
public class WelcomeController {

    @GetMapping("/")
    public String goToWelcomePage(ModelMap model) {
        model.put("name",getLoggedInUserName());
        return "welcome";
    }

//    This is get info form Spring Seecurity about the  logged in user
    public String getLoggedInUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}

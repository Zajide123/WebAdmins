package webAdmins.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webAdmins.demo.entity.user;
import webAdmins.demo.service.userService;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
@Controller
public class userController {
    private String appMode;
    @Autowired
    userService userService;
    @Autowired
    public void WebAppContoller(Environment environment){
        appMode = environment.getProperty("app-mode");
    }

    @RequestMapping(value = "/User/{login}",method = RequestMethod.POST)
    public user GetUserInfo(@PathVariable(value = "login") String login,
                           @Valid @RequestBody String password)
    {
        user User = userService.FindByLogin(login);
        if(User.getPassword().equals(password)){
            return User;

        }
        else {
            return null;
        }

    }
    @RequestMapping(value = "/Users")
    public List<webAdmins.demo.entity.user> sample() {
        return userService.getAllUsers();
    }
    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public user createUser(@Valid @RequestBody user User) {
        return userService.createUser(User);
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSample(@PathVariable(value = "id") int id) {
        return userService.deleteUser(id);
    }

    @RequestMapping(value = "/updateUser/{id}", method = RequestMethod.PUT)
    public user updateUser(@PathVariable(value = "id") int id,
                                     @Valid @RequestBody user User) {
        return userService.updateUser(id, User);
    }
    @GetMapping("/login")
    public String login(String error, String logout){
        if(error != null){
            return "Your userName and password is invalid.";
        }

        if(logout != null){
            return "You have been logged out successfully.";
        }

        return "login";
    }
    @RequestMapping("/")
    public String index(Model model){

        return "index";
    }

}

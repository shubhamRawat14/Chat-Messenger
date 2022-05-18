package com.knoldus.main_module.controller;
import com.knoldus.main_module.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;

@Scope("session")
@Controller
public class MainController {
    @Autowired
    public User user;
    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("user",user);
        return "LoginAndRegistration";
    }
    @PostMapping("/dashboard")
    public String PostSubmit(@ModelAttribute User receivedUser, Model model) {
        // check for login is name is empty that means user login

        if (receivedUser.getName() == null){
            RestTemplate obj = new RestTemplate();
            User result= obj.postForObject("http://localhost:9092/user/login",receivedUser,User.class);
            if (result == null){
                model.addAttribute("message","Incorrect Mobile number or password");
                return "LoginAndRegistration";
            }
            else {
                user = result;
            }
        }
        else {
            System.out.println(receivedUser.getName());
            RestTemplate obj = new RestTemplate();
            String result= obj.postForObject("http://localhost:9092/user/save",receivedUser,String.class);
            if(result != null){

                return "LoginAndRegistration";
            }
        }
        RestTemplate obj = new RestTemplate();
        List<Integer> result= obj.postForObject("http://localhost:9092/message/getUserIdOfPreviousMessage",user,List.class);
        System.out.println(result);
        List<User> listUser = new LinkedList<>();
        for (int index: result ) {
            RestTemplate object = new RestTemplate();
            System.out.println(index);
            User getUser = new User();
            getUser.setId(index);
            getUser = object.postForObject("http://localhost:9092/user/fetchUserRelation",getUser,User.class);
            listUser.add(getUser);
            System.out.println(getUser.getId());
            System.out.println(getUser.getMobile());
            System.out.println(getUser.getPassword());
            System.out.println(getUser.getName());
        }
        model.addAttribute("listUser",listUser);

        return "chatWindow";
    }
    @PostMapping("/Chat")
    public String Chat(@ModelAttribute User receivedUser, Model model) {
        System.out.println(receivedUser.getName());
        return "chatWindow";
    }
}

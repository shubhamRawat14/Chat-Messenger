package com.knoldus.user_module.controller;
import com.knoldus.user_module.Model.User;
import com.knoldus.user_module.repository.UserRepository;
import com.knoldus.user_module.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
@Scope("session")
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    UserServices userServices;
    @Autowired
    private  User user;
    @Autowired
    UserRepository userRepository;
    @PostMapping(path="/save")
    public @ResponseBody String addNewUser (@RequestBody User receivedUserDetails) {
        return userServices.addNewUserService(receivedUserDetails);
    }
    @PostMapping(path="/edit")
    public @ResponseBody String updateUser (@RequestBody User receivedUserDetails) {

        return userServices.updateUserService(receivedUserDetails);
    }
    @DeleteMapping(path = "/delete")
    public @ResponseBody String deleteUser(@RequestBody User receivedUserDetails) {
      return userServices.deleteUserService(receivedUserDetails);
    }
    @PostMapping(path = "/login")
    public @ResponseBody User loginUser(@RequestBody User receivedUserDetails) {
       return userServices.loginService(receivedUserDetails);
    }
    @PostMapping(path = "/fetch/list")
    public @ResponseBody User fetchUserList(@RequestBody User receivedUserDetails) {
        System.out.println(receivedUserDetails.getMobile());
       return userServices.fetchUserListService(receivedUserDetails);
    }
    @PostMapping(path = "/fetchUserRelation")
    public @ResponseBody User fetchUserRelation(@RequestBody User receivedUserDetails){
        System.out.println(receivedUserDetails.getId());
        return userServices.fetchUserRelationService(receivedUserDetails);
    }
    @PostMapping(path = "/searchUser")
    public @ResponseBody User searchUserbyMobile(@RequestBody User
                                                             receiveUser){
        System.out.println(receiveUser.getMobile());
        return userServices.searchUserbyMobile(receiveUser.getMobile());
    }
}

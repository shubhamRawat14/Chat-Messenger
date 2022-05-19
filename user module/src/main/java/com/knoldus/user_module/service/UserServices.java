package com.knoldus.user_module.service;

import com.knoldus.user_module.Model.User;
import com.knoldus.user_module.repository.UserRepository;
import com.knoldus.user_module.validation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
/**
 * User Service.
 */

@Service
public class UserServices {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserValidation userValidation;

    /**
     *
     * @param receivedUserDetails
     * @return
     */
    public String addNewUserService(final User receivedUserDetails) {
        String checkMobile = userValidation
                .validateMobile(receivedUserDetails
                .getMobile());
        String userExists="";
        String validatePassword = userValidation.isValidPassword(receivedUserDetails.getPassword());
        if(checkMobile == "" && validatePassword == ""  && !userRepository.existsByMobile(receivedUserDetails.getMobile())){
            User user = new User();
            user.setName(receivedUserDetails.getName());
            user.setMobile(receivedUserDetails.getMobile());
            user.setPassword(receivedUserDetails.getPassword());
            user.setActive(true);
            Date date = new Date();
            user.setCreatedDate(date);
            user.setUpdatedDate(date);
            userRepository.save(user);
            return "User saved\n";
        }
        if ( userRepository.existsByMobile(receivedUserDetails.getMobile())){
            userExists += "already exist";
        }

        return checkMobile + validatePassword + userExists;
    }
    public String updateUserService(User receivedUserDetails) {
        String checkMobile = userValidation
                .validateMobile(receivedUserDetails
                        .getMobile());
        String validatePassword = userValidation.isValidPassword(receivedUserDetails.getPassword());
        if(userRepository.existsById(receivedUserDetails.getId()) && !userRepository.existsByMobile(receivedUserDetails.getMobile())){
            if (checkMobile == "" && validatePassword == ""){
                Date date = new Date();
                User editUser = userRepository.getById(receivedUserDetails.getId());
                editUser.setName(receivedUserDetails.getName());
                editUser.setPassword(receivedUserDetails.getPassword());
                editUser.setMobile(receivedUserDetails.getMobile());
                editUser.setUpdatedDate(date);
                userRepository.save(editUser);
                return "user updated\n";
            }
            return checkMobile + validatePassword;
        }
        return "user does not exists";
    }
    public String deleteUserService(User receivedUserDetails) {
        if (userRepository.existsById(receivedUserDetails.getId())){
            Date date = new Date();
            User editUser = userRepository.getById(receivedUserDetails.getId());
            editUser.setUpdatedDate(date);
            editUser.setActive(false);
            userRepository.save(editUser);
            return editUser.getName() + " is deleted\n";
        }
        return receivedUserDetails.getName() + " does not exist";
    }
    public User loginService(User receivedUserDetails){
        // For Authentication
        User user = userRepository.fetchUser(receivedUserDetails.getMobile(), receivedUserDetails.getPassword());
//        if(user != null) {
//            return "Welcome " +user.getName() + "\n ";
//        }
        return user;
    }
    public User fetchUserListService( User user){
        return userRepository.findUser(user.getMobile());
    }
    public User fetchUserRelationService(User user){
      //  System.out.println(user.getId());
        return userRepository.findUserById(user.getId());
    }
    public User searchUserbyMobile(Long mobile){
        //System.out.println(mobile);
        return userRepository.findbyMobile(mobile);
    }
}

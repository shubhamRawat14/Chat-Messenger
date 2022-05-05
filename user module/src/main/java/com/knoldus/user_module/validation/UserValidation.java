package com.knoldus.user_module.validation;

import org.springframework.stereotype.Service;

@Service
public class UserValidation {
    public String validateMobile(final Long mobileNumber){
        String mobileValidation = mobileNumber.toString();
        if (mobileValidation.length() != 10 ){
            return "Invalid Mobile Number!\nEnter 10 digit mobile number\n";
        }
        return "";
    }
    public String isValidPassword(final String password)
    {
        String checkPassword="";
        if (password.length() > 15 || password.length() < 8)
        { checkPassword += "Password must be less than 20 and more than 8 characters in length.\n"; }
        String upperCaseChars = "(.*[A-Z].*)";
        if (!password.matches(upperCaseChars ))
        { checkPassword += "Password must have atleast one uppercase character\n"; }
        String lowerCaseChars = "(.*[a-z].*)";
        if (!password.matches(lowerCaseChars ))
        { checkPassword += "Password must have atleast one lowercase character\n"; }
        String numbers = "(.*[0-9].*)";
        if (!password.matches(numbers ))
        { checkPassword += "Password must have atleast one number\n"; }
        String specialChars = "(.*[@,#,$,%,!,_].*$)";
        if (!password.matches(specialChars ))
        {  checkPassword += "Password must have atleast one special character among @#$%!_\n"; }
        return checkPassword;
    }
}

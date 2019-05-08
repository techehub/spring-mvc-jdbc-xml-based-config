package com.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.myapp.model.Login;
import com.myapp.service.UserService;
import com.myapp.model.User;
import com.myapp.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {
    @Autowired
    public UserService userService;

    @Autowired
    public UserValidator userValidator;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("register");
        User u= new User();
        mav.addObject("user", u);
        return mav;
    }

    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
                                @ModelAttribute("user") @Valid User user ,
                                BindingResult bindingResult) {


        //Validation code
        //userValidator.validate(user, bindingResult);



        User userObj = userService.validateUserNameExists(user.getUsername());
        if (null != userObj) {
            FieldError userError = new FieldError("username", "username", "User already Exists");
            bindingResult.addError(userError);
        }


        //Check validation errors
        if (bindingResult.hasErrors()) {

            ModelAndView mav = new ModelAndView("register");
            mav.addObject("user", user);
            return mav;
        }



        userService.register(user);

        return new ModelAndView("welcome", "firstname", user.getFirstname());
    }
}
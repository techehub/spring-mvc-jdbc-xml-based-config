package com.myapp.controller;

import com.myapp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MyController {


    @RequestMapping(value = "/hai", method = RequestMethod.GET)
    public ModelAndView sahdhsagdjhgjahsd(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("mypage");

        User u= new User();
        u.setEmail("dsfdsdf");


        mav.addObject("msg", "GoodMorning");
        mav.addObject("user", u);
        return mav;
    }


}

package com.myapp.controller;

import com.myapp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MyController {

	
	 @RequestMapping(value = "/getUser/{username}/{userid}", method = RequestMethod.GET)
	    public ModelAndView getUser(HttpServletRequest request, HttpServletResponse response ,
	    		@PathVariable("username") String username, @PathVariable("userid") String uid) {
		 
		    ModelAndView mav = new ModelAndView("mypage");

	        mav.addObject("msg", username);
	        mav.addObject("msg2", uid);
	        
	        return mav;
	    }
	

	 
	 @RequestMapping(value = "/getUser1/{username}", method = RequestMethod.GET)
	    public String getUser1(@PathVariable("username") String username, ModelMap modelMap ) {
	     	modelMap.addAttribute("msg",username);
		    return "mypage";
	    }
	 
	 
    @RequestMapping(value = "/hai", method = RequestMethod.GET)
    public ModelAndView sahdhsagdjhgjahsd(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("mypage");
        
        mav.addObject("msg", "GoodMorning");
       // mav.addObject("user", u);
        return mav;
    }


}

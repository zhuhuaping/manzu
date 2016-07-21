package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.User;
import com.service.UserService;

@Controller
public class UserComtroller {

	@Autowired
	private UserService userService;

	@RequestMapping("/user/loginView")
	public ModelAndView loginView() {
		return new ModelAndView("hello");
	}

	@RequestMapping("/user/registerView")
	public String registerView() {
		return "register";
	}

	@RequestMapping("/user/login")
	public ModelAndView login(User user) {
		ModelAndView mav = new ModelAndView();
		User u = userService.loginCheck(user);
		if (null == u) {
			mav.setViewName("login");
			mav.addObject("errorMsg", "�û�������������");
			return mav;
		} else {
			mav.setViewName("success");
			mav.addObject("user", u);
			return mav;
		}
	}

	@RequestMapping("/user/register")
	public ModelAndView register(User user) {
		ModelAndView mav = new ModelAndView();
		if (userService.register(user)) {
			mav.setViewName("register_succ");
			return mav;
		} else {
			mav.setViewName("register");
			mav.addObject("errorMsg", "�û����ѱ�ռ�ã����������");
			return mav;
		}
	}
}

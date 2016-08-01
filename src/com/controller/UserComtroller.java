package com.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.common.CheckUtils;
import com.common.Consts;
import com.model.User;
import com.service.UserService;

@Controller
public class UserComtroller {

	@Autowired
	private UserService userService;

	@RequestMapping("/user/login")
	public String loginView() {
		return "login";
	}

	@RequestMapping("/user/loginDeal")
	public ModelAndView login(User u) {
		ModelAndView mav = new ModelAndView();
		Map<Object, Object> checkRst = userService.loginCheck(u);

		User user = (User) checkRst.get(Consts.USER);
		String msg = (String) checkRst.get(Consts.MSG);

		if (!CheckUtils.isNull(user)) {
			mav.setViewName("login");
			mav.addObject(Consts.USER, user);
		} else {
			mav.setViewName("login");
		}

		mav.addObject(Consts.MSG, msg);
		return mav;
	}

	@RequestMapping("/user/registerView")
	public String registerView() {
		return "register";
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

package com.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.common.CheckUtils;
import com.common.Consts;
import com.common.Enum.Reg_Rst;
import com.model.User;
import com.service.UserService;

@Controller
public class UserComtroller {

	@Autowired
	private UserService userService;

	@RequestMapping("/user/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/user/loginDeal")
	public ModelAndView loginDeal(User inputUser, HttpSession session) {
		Map<Object, Object> checkRst = userService.login(inputUser);
		User dbUser = (User) checkRst.get(Consts.USER);
		String msg = (String) checkRst.get(Consts.MSG);

		session.setAttribute(Consts.MSG, msg);

		ModelAndView mav = new ModelAndView();
		if (!CheckUtils.isNull(dbUser)) {
			mav = new ModelAndView("redirect:/home.do");
			mav.addObject(Consts.USER, dbUser);
		} else {
			mav.setViewName("login");
		}

		return mav;
	}

	@RequestMapping("/user/register")
	public String register() {
		return "register";
	}

	@RequestMapping("/user/registerDeal")
	public ModelAndView registerDeal(User user) {
		Map<Object, Object> checkRst = userService.register(user);
		Object registerRst = checkRst.get(Consts.REG_RST);
		String msg = (String) checkRst.get(Consts.MSG);

		ModelAndView mav = new ModelAndView();
		mav.addObject(Consts.MSG, msg);

		if (registerRst.equals(Reg_Rst.SUCCESS)) {
			mav = new ModelAndView("redirect:/user/login.do");
		} else if (registerRst.equals(Reg_Rst.FAIL)) {
			mav.setViewName("register");
		}

		return mav;
	}
}

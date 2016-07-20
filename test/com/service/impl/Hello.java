package com.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class Hello extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String helloStr = request.getParameter("hello");

		System.out.print("-----helloStr-----" + helloStr);

		ModelAndView helloView = new ModelAndView("hello");
		helloView.addObject("HelloWorld", helloStr);
		return helloView;  
	}
}

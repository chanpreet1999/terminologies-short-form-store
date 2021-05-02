package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller("error")
public class ErrorController {

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(HttpServletRequest request, Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("url", request.getRequestURL());
		mv.addObject("error", e.getMessage());
		mv.setViewName("error");
		return mv;
	}
}
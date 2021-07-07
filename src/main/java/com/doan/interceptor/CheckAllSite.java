package com.doan.interceptor;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
public class CheckAllSite implements HandlerInterceptor {
	public boolean preHandle(
			  HttpServletRequest request,
			  HttpServletResponse response, 
			  Object handler) throws Exception {
				System.out.println("ta da den day0"+response.getStatus());
				return true;
				
			}
	public void postHandle(
			  HttpServletRequest request, 
			  HttpServletResponse response,
			  Object handler, 
			  ModelAndView modelAndView) throws Exception {
		System.out.println("ta da den day1"+response.getStatus());
		if(response.getStatus()==500 ||response.getStatus()==400 || response.getStatus()==404 || response.getStatus()==403 ) {
			   try {
				response.sendRedirect("home");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }  		  
			}
	public void afterCompletion(
			  HttpServletRequest request, 
			  HttpServletResponse response,
			  Object handler, Exception ex) {
		System.out.println("ta da den day2"+response.getStatus());
			   if(response.getStatus()==500 ||response.getStatus()==400 || response.getStatus()==404 || response.getStatus()==403 ) {
				   try {
					response.sendRedirect("home");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   }
			}
}

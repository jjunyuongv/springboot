package com.edu.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.springboot.jdbc.ITicketService;

@Controller
public class MainController
{
	@Autowired
	ITicketService dao;
	
	@Autowired
	PlatformTransactionManager transactionManager;
	
	@Autowired
	TransactionDefinition definition;
	
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	
	@RequestMapping(value="/buyTicket.do", method = RequestMethod.GET)
	public String buy1() {
		return "buy";
	}
	
	
}

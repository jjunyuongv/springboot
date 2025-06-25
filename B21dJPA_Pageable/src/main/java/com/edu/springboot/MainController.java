package com.edu.springboot;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.springboot.jpa.Member;
import com.edu.springboot.jpa.MemberService;


@Controller
public class MainController
{
	@Autowired
	MemberService memberService;
	
	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/selectByNameLike.do")
	public String selectByNameLike(
			@RequestParam("name") String pname,
			@RequestParam("page") String page,
			Model model) {
		System.out.println("selectMembers3(검색어) : "+ pname );
		System.out.println("selectMembers3(페이지) : "+ page );
		
		String name = pname +"%";
		Sort sort = Sort.by(Sort.Order.desc("id"));
		int pageNum = Integer.parseInt(page) - 1;
		
		Pageable pageable = PageRequest.ofSize(5).withPage(pageNum)
				.withSort(sort);
		Page<Member> result = memberService
				.selectNameLike(name, pageable);
		List<Member> content = result.getContent();
		
		
		
	}
	
	
}

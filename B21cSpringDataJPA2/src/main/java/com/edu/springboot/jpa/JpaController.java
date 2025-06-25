package com.edu.springboot.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JpaController
{
	@Autowired
	MemberService memberService;
	
	@GetMapping("/insert")
	public String insert(Member member, Model model ) {
		memberService.insert();
		
		return "insert";
	}
	
//	@GetMapping("/selectAll")
//	public String selectAll(Model model) {
//		List<Member> result = memberService.selectAll();
//		model.addAttribute("title", "Select All");
//		model.addAttribute("result", result);
//		model.addAttribute("mode", 2); //0:메세지만, 1:단일행, 2:복수행
//		return "selectAll";
//	}
//	
//	@GetMapping("/selectById")
//	public String selectById(@RequestParam("id") Long search,
//			Model model) {
//		Optional<Member> result = memberService.selectId(search);
//		model.addAttribute("member", result.get());
//		return "select_id";
//	}
//	
//	@GetMapping("/selectByName")
//	public String selectByName(@RequestParam("name") String search,
//			Model model) {
//		Optional<Member> result = memberService.selectName(search);
//		model.addAttribute("member", result.get());
//		return "select_name";
//	}
//	
//	
//	@GetMapping("/selectByEmail")
//	public String selectByEmail(@RequestParam("email") String search,
//			Model model) {
//		Optional<Member> result = memberService.selectEmail(search);
//		model.addAttribute("member", result.get());
//		return "select_email";
//	}
//	
//	@GetMapping("/selectByNameLike")
//	public String selectByNameLike
//			(@RequestParam("name") String search, Model model) {
//		String name = search + "%";
//		List<Member> result = memberService.selectNameLike(name);
//		model.addAttribute("members", result);
//		return "select_name_list";
//	}
//	
//	@GetMapping("/selectByNameLikeNameDesc")
//	public String selectByNameLikeNameDesc(
//			@RequestParam("name") String search, Model model) {
//		String name = search + "%";
//		List<Member> result = memberService
//				.selectNameLikeNameDesc(name);
//		model.addAttribute("members", result);
//		return "selectByNameLikeNameDesc";
//	}
//	
//	@GetMapping("/selectByNameLikeOrder")
//	public String selectByNameLikeOrder(
//			@RequestParam("name") String search, Model model) {
//		String name = search + "%";
//		
//		Sort sort = Sort.by(Sort.Order.desc("name"));
////		Sort sort = Sort.by(Sort.Order.desc("name"),
////				Sort.Order.asc("email"));
//		List<Member> result = memberService
//				.selectNameLike(name, sort);
//		model.addAttribute("title", "Select By "
//				+ " Like Name Desc(Sort사용)");
//		model.addAttribute("result", result);
//		model.addAttribute("mode", 2); //0:메세지만, 1:단일행, 2:복수행
//		return "selectByNameLikeOrder";
//	}
}

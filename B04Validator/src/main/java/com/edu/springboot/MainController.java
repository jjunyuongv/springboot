package com.edu.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

/*
JSP에서는 컨트롤러로 정의하기 위해 Servlet 클래스로 정의한 후
매핑정보를 입력하였다. Spring boot에서는 아래와 같이 @Controller
어노테이션을 부착하면 자동으로 컨트롤러 클래스로 정의된다. 또한 사용을
위해 별도로 인스턴스를 생성할 필요없이 스프링 컨테이너가 시작시 자동으로
인스턴스(빈)을 생성해준다.  
 */
@Controller
public class MainController
{
	//home 경로 매핑 
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	
	@RequestMapping("/write.do")
	public String insert1() {
		return "write";
	}
	
	@RequestMapping("/writeAction1.do")
	public String writeAction1(@ModelAttribute("dto") BoardDTO boardDTO,
			BindingResult result) {
		
		String page = "result";
		System.out.println(boardDTO);
		
		BoardValidator validator = new BoardValidator();
		validator.validate(boardDTO, result);
		
		if(result.hasErrors()) {
			page = "write";
			System.out.println("검증 실패 반환값1:"+ result.toString());
			
			if(result.getFieldError("title")!=null) {
				System.out.println("제목 검증1(에러코드):"
						+result.getFieldError("title").getCode());
			}
			
			if(result.getFieldError("content")!=null) {
				System.out.println("제목 검증1(디폴트메세지):"
						+result.getFieldError("content").getDefaultMessage());
			}
		}
		
		return page;
	}
}

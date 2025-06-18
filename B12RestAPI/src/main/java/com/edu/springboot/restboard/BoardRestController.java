package com.edu.springboot.restboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class BoardRestController
{
	@Autowired
	IBoardService dao;
	
	@GetMapping("/restBoardList.do")
	public List<BoardDTO> restBoardList(ParameterDTO parameterDTO) {
		
		int pageSize = 10;
		int pageNum = parameterDTO.getPageNum()==null ? 1 :
			Integer.parseInt(parameterDTO.getPageNum());
		int start = (pageNum -1) * pageSize + 1;
		int end = pageNum * pageSize;
		parameterDTO.setStart(start);
		parameterDTO.setEnd(end);
		List<BoardDTO> boardList = dao.list(parameterDTO);
		return boardList;
	}
	
	@GetMapping("/restBoardSearch.do")
	public List<BoardDTO> restBoardSearch(HttpServletRequest req,
			ParameterDTO parameterDTO) {
		
//		searchField는 parameterDTO가 받음
//		searchWord는 별도로 저장해야함
		if(req.getParameter("searchWord")!=null) {
			String[] sTxtArray = req.getParameter("searchWord").split(" ");
			parameterDTO.getSearchWord().clear();
			for(String str : sTxtArray) {
				System.out.println(str);
				parameterDTO.getSearchWord().add(str);
			}
		}
		List<BoardDTO> searchList = dao.search(parameterDTO);
		return searchList;
	}
}

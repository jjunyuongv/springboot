package com.edu.springboot;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController
{
	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	
	@RequestMapping("/json.do")
	@ResponseBody
	public String json() {
		JSONArray arr = new JSONArray();
		JSONObject obj = new JSONObject();
		
		arr.add("손오공");
		arr.add("저팔계");
		arr.add("사오정");
		obj.put("서유기", arr);
		obj.put("result", 1);
		
		return obj.toJSONString();
	}
	
	@RequestMapping("/jsonQuiz.do")
	@ResponseBody
	public String jsonQuiz() {
		JSONObject objResult = new JSONObject();
		
		JSONArray arr1 = new JSONArray();
		arr1.add("자전거"); arr1.add("수영"); arr1.add("축구"); 
		
		JSONArray arrMidFriend = new JSONArray();
		arrMidFriend.add("손오공"); arrMidFriend.add("저팔계");
		arrMidFriend.add("사오정");
		
		JSONArray arrCircle = new JSONArray();
		arrCircle.add("유비"); arrCircle.add("관우");
		arrCircle.add("장비");
		
		JSONArray arrClass = new JSONArray();
		arrClass.add("이몽룡"); arrClass.add("성춘향");
		
		JSONObject objHighFriend = new JSONObject();
		objHighFriend.put("circle", arrCircle); 
		objHighFriend.put("class", arrClass); 
		
		JSONObject objFriend = new JSONObject();
		objFriend.put("mid", arrMidFriend);
		objFriend.put("high", objHighFriend);
		
		objResult.put("name", "홍길동");
		objResult.put("age", 99);
		objResult.put("hobby", arr1);
		objResult.put("friend", objFriend);
		return objResult.toJSONString();
	}
	
}

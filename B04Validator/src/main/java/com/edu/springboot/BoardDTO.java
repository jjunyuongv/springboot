package com.edu.springboot;

import lombok.Data;

@Data
public class BoardDTO
{
	private int idx;
	private String userid;
	private String title;
	private String content;
}

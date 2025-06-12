package com.edu.springboot.bean2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("macBook")
public class Computer
{
	@Value("M4")
	private String cpu;

	public void setCpu(String cpu)
	{
		this.cpu = cpu;
	}

	@Override
	public String toString()
	{
		return "Notebook [cpu=" + cpu + "]";
	}
	
	
	
}

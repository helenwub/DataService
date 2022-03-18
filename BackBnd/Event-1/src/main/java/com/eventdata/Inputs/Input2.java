package com.eventdata.Inputs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.eventdata.model.Car;

public class Input2{
	
	
	public Car saveClassModel2() throws Exception
	{
	File file = new File("C:\\Users\\Helen Wubneh\\Desktop\\Mode2.txt");
	
	
	 BufferedReader br = new BufferedReader(new FileReader(file));
	 String st;
	 Car c=new Car();
	 while ((st = br.readLine()) != null)
	 {
		 
		 c.setModel(st);
	 }
	 return c;
	}
   
}

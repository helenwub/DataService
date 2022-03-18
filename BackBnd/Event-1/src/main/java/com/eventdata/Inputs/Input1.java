package com.eventdata.Inputs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.eventdata.model.Car;

public class Input1 {

	
	public Car saveClassModel1() throws Exception//reads a file and returns car
	{
		File file = new File(
	            "C:\\Users\\Helen Wubneh\\Desktop\\Mode1.txt");
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

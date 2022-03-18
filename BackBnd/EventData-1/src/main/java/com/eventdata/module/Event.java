package com.eventdata.module;
import javax.persistence.Id;

import lombok.*;

@Data


public class Event {
	@Id
	Long id;
	String title;
	String description;
	String autherName;
	public Event(String title, String description, String autherName) {
		super();
		this.title = title;
		this.description = description;
		this.autherName = autherName;
	}
	

}

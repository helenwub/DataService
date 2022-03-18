package com.eventdata.model;

import java.time.*;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String url;
	String eventTitle;
	LocalDate date;
	String location;
}

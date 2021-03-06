package com.eventdata.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eventdata.model.EventData;
import com.eventdata.service.EventService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/event")
public class Controller{

	@Autowired
	EventService evntSer;
	
	@GetMapping("/eventDatas")
	public ResponseEntity<List<EventData>> getAll() {
		return new ResponseEntity<>(evntSer.getAll(), HttpStatus.OK);
    }
}

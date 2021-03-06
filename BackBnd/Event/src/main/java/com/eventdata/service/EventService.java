package com.eventdata.service;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eventdata.model.EventData;
import com.eventdata.repo.EventRepository;
import com.eventdata.scraper.TechMeme;
import com.eventdata.scraper.ComputerWorld;

@Service
public class EventService {
	@Autowired
	EventRepository repo;
	private static final Logger LOGGER = LoggerFactory.getLogger(EventService.class);
	
    @Async
    public CompletableFuture<List<EventData>> scrapCwEvents() 
    {
    	final ComputerWorld s=new ComputerWorld();
    	List<EventData> events=null;
		try {
			events=s.extractEvents();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		repo.saveAll(events);
    	return CompletableFuture.completedFuture(events);
    }
    @Async
    public CompletableFuture<List<EventData>> scrapTmEvents()
    {
		final TechMeme scraper=new TechMeme();
		List<EventData> events=null;
		final long start = System.currentTimeMillis();
		LOGGER.info("Start time: {}",  start);
		try {
			events=scraper.extractEvents();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		repo.saveAll(events);
    	return CompletableFuture.completedFuture(events);
    }

	public List <EventData> getAll() 
	{
	    scrapCwEvents();
	    scrapTmEvents();
	    return repo.findAll();
	}
}

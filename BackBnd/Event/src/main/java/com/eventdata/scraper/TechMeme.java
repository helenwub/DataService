package com.eventdata.scraper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.eventdata.model.EventData;

public class TechMeme {
	
	
	public List <EventData> extractEvents()throws IOException
	{
		
	  final	List <EventData> events=new ArrayList<>();
	  final Document doc=Jsoup.connect("https://www.techmeme.com/events").get();
	  Elements webTitleElements=doc.getElementsByClass("evhed");
	  webTitleElements = webTitleElements.get(0).select("a[href]");
	  
	  final Elements eventElements=doc.getElementsByClass("rhov");
	  doc.select("em").remove();
	  for(final Element eventData:eventElements)
	  {
		  EventData event=new EventData();
		  Elements titleElements = eventData.getElementsByTag("a");
		  titleElements = titleElements.get(0).getElementsByTag("div");
		    
		     event.setWebName(doc.title());
		     event.setEventDate(titleElements.get(0).getElementsByIndexEquals(0).text());
		     event.setEventName(titleElements.get(1).getElementsByIndexEquals(1).text());
		     event.setLocation(titleElements.get(2).getElementsByIndexEquals(2).text());
		   
		     events.add(event);
	  } 
	  return events; 
	}

}

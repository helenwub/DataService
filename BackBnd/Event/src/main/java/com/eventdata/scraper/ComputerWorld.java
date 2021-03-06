package com.eventdata.scraper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.eventdata.model.EventData;

public class ComputerWorld {
	
	public List <EventData> extractEvents()throws IOException
	{
		
	  final	List <EventData> events=new ArrayList<>();
	  final Document doc=Jsoup.connect("https://www.computerworld.com/article/3313417/tech-event-calendar-shows-conferences-and-it-expos-updated.html").get();
	  final Element eventTable=doc.getElementById("cwsearchabletable");
	  Elements tableBody=eventTable.getElementsByTag("tbody");
	  Elements tableRaw=tableBody.get(0).getElementsByTag("tr");
	  for(final Element eventData:tableRaw)
	  {
		  StringJoiner mystring = new StringJoiner(" - ");
		  EventData event=new EventData();
		  Elements webSiteName=doc.getElementsByClass("logo");
		  mystring.add(eventData.select("td").get(1).text());
		  mystring.add(eventData.select("td").get(2).text());
		  event.setEventName(eventData.select("th").text());
		  event.setEventDate(mystring.toString());
		  event.setLocation(eventData.select("td").get(3).text());
		  event.setWebName(webSiteName.get(0).text());
		  events.add(event);
	  } 
	  return events; 
	}
}

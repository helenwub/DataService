import { Component, OnInit } from '@angular/core';
import { EventData } from 'src/app/common/event';
import { EventService } from 'src/app/services/event.service';

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.css']
})
export class EventListComponent implements OnInit {

  events!: EventData[];
  SortbyParam = '';
  SortDirection = 'asc';
  SearchEvent='';
  Name='';

  constructor(private eventService: EventService) { }

  ngOnInit(): void {
    this.listEvents();
  }
  listEvents() {
   this.eventService.getEventList().subscribe(
     data => {
       this.events=data;
     })
  }
  onEventFilter() {
    this.SearchEvent = this.Name;
  }

  onEventFilterClear() {
    this.SearchEvent = '';
    this.Name = '';
  }
  onSortDirection() {
    if (this.SortDirection === 'desc') {
      this.SortDirection = 'asc';
    } else {
      this.SortDirection = 'desc';
    }
  }
}

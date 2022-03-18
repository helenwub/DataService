import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
// import {Observable} from 'rxjs/Observable';
import {map} from 'rxjs/operators';
import { EventData } from '../common/event';
@Injectable({
  providedIn: 'root'
})
export class EventService {
  private baseUrl='http://localhost:8085/event/eventDatas';

  constructor(private httpClient:HttpClient) { }

  getEventList():Observable<EventData[]>
  {
    return this.httpClient
    .get<EventData[]>(this.baseUrl)
    
  }
}


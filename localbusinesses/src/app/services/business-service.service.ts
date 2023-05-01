import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { restuarnt } from '../model/restuarant';
import { hotel } from '../model/hotels';
import { homeservice } from '../model/homeservice';
import { business } from '../model/business';
import { autoservice } from '../model/autoservices';
import { entertainment } from '../model/entertainment';
import { beauty } from '../model/beauty';

@Injectable({
  providedIn: 'root'
})
export class BusinessServiceService {

  constructor(private http:HttpClient) { }
  url: string = "http://localhost:3000/restuarnts"
  baseurl:string="http://localhost:4000/hotels"
  base:string="http://localhost:5000/homeservice"
  ba:string="http://localhost:7000/bussiness"
  auto:string="http://localhost:3567/autoservices"
  entertainment:string="http://localhost:4444/entertainment"
  beauty:string="http://localhost:5555/beauty"
  getRestuarnts()
  {
    return this.http.get<restuarnt[]>(this.url);
  }
  getHotls()
  {
    return this.http.get<hotel[]>(this.baseurl);
  }
  getHomeservices()
  {
    return this.http.get<homeservice[]>(this.base);
  }
  getbusiness()
  {
    return this.http.get<business[]>(this.ba);
  }
  getautoservices()
  {
    return this.http.get<autoservice[]>(this.auto);
  }
  getentertainment()
  {
    return this.http.get<entertainment[]>(this.entertainment);
  }
  getbeauty()
  {
    return this.http.get<beauty[]>(this.beauty);
  }

}


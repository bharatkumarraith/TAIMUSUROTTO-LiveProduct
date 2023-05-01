import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { BusinessServiceService } from '../services/business-service.service';
import { autoservice } from '../model/autoservices';


@Component({
  selector: 'app-auto-services',
  templateUrl: './auto-services.component.html',
  styleUrls: ['./auto-services.component.css']
})
export class AutoServicesComponent implements OnInit{
  hotel: autoservice[]= [];
  address:any;
  rating:any;
  price:any;
  constructor(private res:BusinessServiceService){}
    ngOnInit(): void {
      this.res.getautoservices().subscribe(response=>{
        this.hotel=response;
      })
    }
  
    search()
    {
  
      if(this.address == "")
      {
        this.ngOnInit();
      }
      else{
        this.hotel=this.hotel.filter(res=>{
          return res.address?.toLowerCase().match(this.address.toLocaleLowerCase());
        })
      }
    }
    book()
    {
     Swal.fire("Thank You...",'You Booked Sucessfully','success');
    }
    searchh()
    {
      
      if(this.rating == "")
      {
        this.ngOnInit();
      }
      else{
        this.hotel=this.hotel.filter(res=>{
      return res.rating?.toLowerCase().match(this.rating.toLocaleLowerCase());
        })
      }
    }
    searchhh()
    {

        
      if(this.price == "")
      {
        this.ngOnInit();
      }
      else{
        this.hotel=this.hotel.filter(res=>{
      return res.price?.toLowerCase().match(this.price.toLocaleLowerCase());
        })
      }

    }
}

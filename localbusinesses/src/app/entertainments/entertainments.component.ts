import { Component } from '@angular/core';
import { entertainment } from '../model/entertainment';
import { BusinessServiceService } from '../services/business-service.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-entertainments',
  templateUrl: './entertainments.component.html',
  styleUrls: ['./entertainments.component.css']
})
export class EntertainmentsComponent {
  hotel: entertainment[]= [];
  address:any;
  rating:any;
  price:any;
  constructor(private res:BusinessServiceService){}
    ngOnInit(): void {
      this.res.getentertainment().subscribe(response=>{
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



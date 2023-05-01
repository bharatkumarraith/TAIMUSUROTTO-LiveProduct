import { Component } from '@angular/core';
import { homeservice } from '../model/homeservice';
import { BusinessServiceService } from '../services/business-service.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-home-services',
  templateUrl: './home-services.component.html',
  styleUrls: ['./home-services.component.css']
})
export class HomeServicesComponent {
  homeservice: homeservice[]= [];
  address:any;
  rating:any;
  price:any;
  constructor(private res:BusinessServiceService){}
  ngOnInit(): void {
    this.res.getHomeservices().subscribe(response=>{
      this.homeservice=response;
    })
  }

  search()
  {

    if(this.address == "")
    {
      this.ngOnInit();
    }
    else{
      this.homeservice=this.homeservice.filter(res=>{
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
      this.homeservice=this.homeservice.filter(res=>{
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
      this.homeservice=this.homeservice.filter(res=>{
    return res.price?.toLowerCase().match(this.price.toLocaleLowerCase());
      })
    }

  }
}

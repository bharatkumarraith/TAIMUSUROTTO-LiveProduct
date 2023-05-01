import { Component, OnInit } from '@angular/core';
import { restuarnt } from '../model/restuarant';
import { BusinessServiceService } from '../services/business-service.service';

import Swal from 'sweetalert2';


@Component({
  selector: 'app-resturants',
  templateUrl: './resturants.component.html',
  styleUrls: ['./resturants.component.css']
})
export class ResturantsComponent implements OnInit {
resturant: restuarnt[]= [];
address:any;
rating:any;
constructor(private res:BusinessServiceService){}
  ngOnInit(): void {
    this.res.getRestuarnts().subscribe(response=>{
      this.resturant=response;
    })
  }

  search()
  {

    if(this.address == "")
    {
      this.ngOnInit();
    }
    else{
      this.resturant=this.resturant.filter(res=>{
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
      this.resturant=this.resturant.filter(res=>{
    return res.rating?.toLowerCase().match(this.rating.toLocaleLowerCase());
      })
    }
  }

}

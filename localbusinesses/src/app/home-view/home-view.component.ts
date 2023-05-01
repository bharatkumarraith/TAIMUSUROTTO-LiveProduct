import { Component, OnInit } from '@angular/core';
import { business } from '../model/business';
import { BusinessServiceService } from '../services/business-service.service';
import { Router } from '@angular/router';
import { HotelsViewComponent } from '../hotels-view/hotels-view.component';

@Component({
  selector: 'app-home-view',
  templateUrl: './home-view.component.html',
  styleUrls: ['./home-view.component.css']
})
export class HomeViewComponent implements OnInit{
  business: business[]= [];
  name:any;
selected?:any;
ser:any;
  constructor(private res:BusinessServiceService, private router:Router){
   
  }
  ngOnInit(): void {
    this.res.getbusiness().subscribe(response=>{
      this.business=response;
    })
  }
  search()
  {

    if(this.name == "")
    {
      this.ngOnInit();
    }
    else{
      this.business=this.business.filter(res=>{
        return res.name?.toLowerCase().match(this.name.toLocaleLowerCase());
      })
    }
  }

onselected(res:any): void
{

  this.selected=res;
}

book(names:any)
{
if(names=='RESTURANTS')
{
  this.router.navigateByUrl('/resturants');
}
if(names== 'HOTELS')
{
  this.router.navigateByUrl('/hotels');
}
if(names== 'HOMESERVICES')
{
  this.router.navigateByUrl('/homeservices')
}
if(names=='AUTOSERVICES')
{
  this.router.navigateByUrl('/autoservices');
}
if(names== 'ENTERTAINMENT')
{
  this.router.navigateByUrl('/entertainment');
}
if(names== 'BEAUTY')
{
  this.router.navigateByUrl('/beauty')
}
else{



}
}


}

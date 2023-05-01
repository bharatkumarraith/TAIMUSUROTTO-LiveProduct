import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeViewComponent } from './home-view/home-view.component';
import { ResturantsComponent } from './resturants/resturants.component';
import { HotelsViewComponent } from './hotels-view/hotels-view.component';
import { HomeServicesComponent } from './home-services/home-services.component';
import { AutoServicesComponent } from './auto-services/auto-services.component';
import { BeautyComponent } from './beauty/beauty.component';
import { EntertainmentsComponent } from './entertainments/entertainments.component';

const routes: Routes = [
  {"path":"",redirectTo:"home",pathMatch:"full"},
  {"path":"home",component:HomeViewComponent},
  {"path":"resturants",component:ResturantsComponent},
  {"path":"hotels",component:HotelsViewComponent},
  {"path":"homeservices",component:HomeServicesComponent},
  {"path":"autoservices",component:AutoServicesComponent},
  {"path":"beauty",component:BeautyComponent},
  {"path":"entertainment",component:EntertainmentsComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

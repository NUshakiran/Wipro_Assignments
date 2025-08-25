import { Routes } from '@angular/router';
import { AddPatient } from './patient-service/add-patient/add-patient';
import { EditPatient } from './patient-service/edit-patient/edit-patient';
import { ViewPatient } from './patient-service/view-patient/view-patient';
import { Menu } from './menu/menu';
import { ViewDoctor } from './doctor-service/view-doctor/view-doctor';
import { AddDoctor } from './doctor-service/add-doctor/add-doctor';
import { EditDoctor } from './doctor-service/edit-doctor/edit-doctor';
import { ViewAppointment } from './appointment-service/view-appointment/view-appointment';
import { AddAppointment } from './appointment-service/add-appointment/add-appointment';
import { EditAppointment } from './appointment-service/edit-appointment/edit-appointment';
import { GenerateBill } from './billing-service/generate-bill/generate-bill';
import { ViewBillings } from './billing-service/view-billing/view-billing';


export const routes: Routes = [
  {path:'',component:Menu},
  { path: '', redirectTo: 'patients', pathMatch: 'full' },
  { path: 'patients', component:ViewPatient },
  { path: 'add-patient', component:AddPatient},
  { path: 'edit-patient/:id', component:EditPatient},
  {path:'doctors',component:ViewDoctor},
  {path:'add-doctor',component:AddDoctor},
  {path:'edit-doctor/:id',component:EditDoctor},
  {path:'appointments',component:ViewAppointment},
  {path:'add-appointment',component:AddAppointment},
  {path:'edit-appointment/:id',component:EditAppointment},
  {path:'generate-billing',component:GenerateBill},
  {path:'billings',component:ViewBillings},

];

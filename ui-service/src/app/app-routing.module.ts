import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ScoreComponent} from "./score/score.component";
import {UserComponent} from "./user/user.component";

const appRoutes: Routes = [
  { path: '', redirectTo: '/user', pathMatch: 'full' },
  { path: 'user', component: UserComponent },
  { path: 'score', component: ScoreComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}

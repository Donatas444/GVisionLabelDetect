import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ImageListComponent } from './image-list/image-list.component';
import { UploadComponent } from './upload/upload.component';

const routes: Routes = [
  { path: 'images', component: ImageListComponent },
  { path: 'detectLabels2', component: UploadComponent },
  { path: 'post', component: UploadComponent },
  { path: 'get', redirectTo: 'images', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }

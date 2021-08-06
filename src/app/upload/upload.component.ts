import { Component, OnInit } from '@angular/core';
import { Image } from '../image/image';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css']
})
export class UploadComponent {
  [x: string]: any;

  msg!: String;
  image: Image;

  constructor(
    private httpClient: HttpClient,
    private router: Router) {
    this.image = new Image();
  }

  gotoImageList() {
    this.router.navigate(['/images']).then(() => {
      window.location.reload();
    });
  }

  onSubmit(): Observable<Image> {
    let headers = new HttpHeaders({
      "Content-Type": "application/json; charset=utf-8"
    });
    console.log(headers.get('Content-Type'));
    const body = JSON.stringify(this.image);
    console.log(body)
    console.log(this.image)
    this.httpClient.post<any>('http://localhost:8080/detectLabels2', body, { 'headers': headers })
      .subscribe(
        (body) => console.log(body)
      );;
    return new Observable<Image>();
  }
}

import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Image } from '../image/image';


@Injectable()
export class ServicesService {
  [x: string]: any;

  private imagesUrl: string;

  constructor(private http: HttpClient) {

    this.imagesUrl = 'http://localhost:8080/images';
  }

  public findAll(): Observable<Image[]> {
    return this.http.get<Image[]>(this.imagesUrl);
  }

  public saveImage(image: Image) {

    this.http.post<Image>(this.imagesUrl, Image);
  }

}



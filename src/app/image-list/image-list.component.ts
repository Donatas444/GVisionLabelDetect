import { Component, OnInit } from '@angular/core';
import { Image } from '../image/image';
import { ServicesService } from '../service/services.service';

@Component({
  selector: 'app-image-list',
  templateUrl: './image-list.component.html',
  styleUrls: ['./image-list.component.css']
})
export class ImageListComponent implements OnInit {
  [x: string]: any;

  images!: Image[];

  constructor(private servicesService: ServicesService) {
  }

  ngOnInit() {
    this.servicesService.findAll().subscribe((data: Image[]) => {

      this.images = data;
    });
  }




}

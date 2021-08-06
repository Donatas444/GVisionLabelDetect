package com.example.gvisionimageobjectdetection.controller;

import com.example.gvisionimageobjectdetection.model.Image;
import com.example.gvisionimageobjectdetection.service.ImageService;
import com.example.gvisionimageobjectdetection.service.VisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class VisionController {
    @Autowired
    VisionService visionService;
    @Autowired
    ImageService imageService;

    @GetMapping("/detectLabels")
    public void extractLabels(String imageUrl) {
        visionService.extractLabels(imageUrl);
    }

    @PostMapping(value = "/detectLabels2")
    public Image saveImage(@RequestBody Image image) {
        extractLabels(image.getImageUrl());
        return image;
    }

    @GetMapping("/images")
    public List<Image> findAll() {
        return imageService.findAll();
    }
}
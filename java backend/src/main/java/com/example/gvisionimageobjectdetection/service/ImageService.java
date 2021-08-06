package com.example.gvisionimageobjectdetection.service;

import com.example.gvisionimageobjectdetection.model.Image;
import com.example.gvisionimageobjectdetection.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository;

    public List<Image> findAll() {
        return imageRepository.findAll();
    }
}

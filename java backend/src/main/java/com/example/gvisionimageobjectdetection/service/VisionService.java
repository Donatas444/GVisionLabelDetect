package com.example.gvisionimageobjectdetection.service;

import com.example.gvisionimageobjectdetection.model.Image;
import com.example.gvisionimageobjectdetection.model.Result;
import com.example.gvisionimageobjectdetection.repository.ImageRepository;
import com.example.gvisionimageobjectdetection.repository.ResultRepository;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.vision.CloudVisionTemplate;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VisionService {
    @Autowired
    ImageRepository imageRepository;
    @Autowired
    ResultRepository resultRepository;
    @Autowired
    private ResourceLoader resourceLoader;
    @Autowired
    private CloudVisionTemplate cloudVisionTemplate;

    public void extractLabels(String imageUrl) {
        AnnotateImageResponse response =
                this.cloudVisionTemplate.analyzeImage(
                        this.resourceLoader.getResource(imageUrl), Feature.Type.LABEL_DETECTION);
        Map<String, Float> imageLabels =
                response
                        .getLabelAnnotationsList()
                        .stream()
                        .collect(
                                Collectors.toMap(
                                        EntityAnnotation::getDescription,
                                        EntityAnnotation::getScore,
                                        (u, v) -> {
                                            throw new IllegalStateException(String.format("Duplicate key %s", u));
                                        },
                                        LinkedHashMap::new));
        saveResults(imageUrl, imageLabels);
    }

    public void saveResults(String imageUrl, Map<String, Float> resultScore) {
        Image image = new Image();
        image.setImageUrl(imageUrl);
        imageRepository.save(image);
        resultScore.forEach((key, value) -> {
            Result result = new Result();
            result.setDescription(key);
            result.setScore(value);
            result.setImage(image);
            resultRepository.save(result);
        });
    }
}

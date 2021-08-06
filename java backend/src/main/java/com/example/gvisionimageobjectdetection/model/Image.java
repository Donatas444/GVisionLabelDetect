package com.example.gvisionimageobjectdetection.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long imageId;
    private String imageUrl;
    @OneToMany(mappedBy = "image", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Result> results = new ArrayList<>();

}

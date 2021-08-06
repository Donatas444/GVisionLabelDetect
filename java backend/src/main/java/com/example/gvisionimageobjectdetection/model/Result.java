package com.example.gvisionimageobjectdetection.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long resultId;
    private String description;
    private float score;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "imageId")
    private Image image;
}

package com.application.drugsProject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "blog")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlogModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "image")
    private byte[] image;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "content")
    private String content;
}

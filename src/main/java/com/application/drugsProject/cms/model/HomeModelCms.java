package com.application.drugsProject.cms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "home")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HomeModelCms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "image")
    private byte[] image;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
}

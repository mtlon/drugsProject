package com.application.drugsProject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "drugs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DrugModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "active_substance")
    private String activeSubstance;

    @Column(name = "name")
    private String name;

    @Column(name = "dosage_taking")
    private String dosageTaking;

    @Column(name = "image")
    private Byte[] image;

    @Column(name = "special_warnings")
    private String specialWarnings;

    @Column(name = "contraindications")
    private String contraindications;

    @Column(name = "additional_info")
    private String additionalInfo;

    @Column(name = "indications")
    private String indications;

    @Column(name = "form")
    private String form;

    @Column(name = "price")
    private double price;

    @Column(name = "producer")
    private String producer;
}


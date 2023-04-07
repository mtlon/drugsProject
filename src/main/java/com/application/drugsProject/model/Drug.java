package com.application.drugsProject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "drugs")
@Getter
@Setter
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public Drug() {
    }
    public Drug(Long id,
                String activeSubstance,
                String name,
                String dosageTaking,
                Byte[] image,
                String specialWarnings,
                String contraindications,
                String additionalInfo,
                String indications,
                String form,
                double price,
                String producer) {
        this.id = id;
        this.activeSubstance = activeSubstance;
        this.name = name;
        this.dosageTaking = dosageTaking;
        this.image = image;
        this.specialWarnings = specialWarnings;
        this.contraindications = contraindications;
        this.additionalInfo = additionalInfo;
        this.indications = indications;
        this.form = form;
        this.price = price;
        this.producer = producer;
    }
}

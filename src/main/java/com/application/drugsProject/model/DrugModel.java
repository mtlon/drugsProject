package com.application.drugsProject.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "drugs")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DrugModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "name")
    private String name;

    @Column(name = "active_substance")
    private String activeSubstance;

    @Column(name = "indications")
    private String indications;

    @Column(name = "dosage_taking")
    private String dosageTaking;

    @Column(name = "warnings")
    private String warnings;

    @Column(name = "contraindications")
    private String contraindications;

    @Column(name = "additional_info")
    private String additionalInfo;

}



package com.application.drugsProject.cms.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "drugs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DrugModelCms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "image")
    private Byte[] image;
    @Column(name = "name")
    private String name;
    @Column(name = "active_substance")
    private String activeSubstance;
    @Column(name = "indications")
    private String indications;
    @Column(name = "dosage_taking")
    private String dosageTaking;
    @Column(name = "special_warnings")
    private String specialWarnings;
    @Column(name = "contraindications")
    private String contraindications;
    @Column(name = "additional_info")
    private String additionalInfo;





}

package com.aws.codestar.projecttemplates.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Disk {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private int id;

    @NotNull
    private String name;
    private String description;
    private String img;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY)
    @JoinTable(name = "disk_material",
            joinColumns = {
                    @JoinColumn(
                            name = "diskid",
                            referencedColumnName = "id"
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "materialid",
                            referencedColumnName = "id"
                    )
            }
    )
    private Set<Material> materials = new HashSet<>();
}

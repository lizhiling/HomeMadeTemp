package com.aws.codestar.projecttemplates.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private int id;

    @NotNull
    private OrderType ordertype;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateTime = new Date(System.currentTimeMillis());

    @NotNull
    @ElementCollection(targetClass=Integer.class)
    private Set<Integer> disks = new HashSet<>();

    private String note;
}

enum OrderType{
    Breakfast, Lunch, Dinner
}

package com.aswe.communicraft.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "crafts")
public class CraftEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "craft", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ProjectCraft> projectCraft;

    @OneToMany(mappedBy = "craft", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<UserEntity> users;


}

package com.example.simplelibrary.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter @Setter
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String nim;

    @Version
    @Column(name = "optVersion", columnDefinition = "integer DEFAULT 0")
    private int version;

}

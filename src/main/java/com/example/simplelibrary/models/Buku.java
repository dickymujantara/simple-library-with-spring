package com.example.simplelibrary.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter @Setter
public class Buku {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String judul;
    private String pengarang;
    private String tahunTerbit;

    @Version
    @Column(name = "optVersion", columnDefinition = "integer DEFAULT 0")
    private int version;

}

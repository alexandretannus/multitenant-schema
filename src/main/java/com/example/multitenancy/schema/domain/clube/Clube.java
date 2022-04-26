package com.example.multitenancy.schema.domain.clube;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Entity
@Table(name = "clube")
@Data
@JsonRootName("equipe")
public class Clube implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String nome;
/* 
    @UpdateTimestamp
    @Column(name = "atualizado")
    private OffsetDateTime atualizado; */

}

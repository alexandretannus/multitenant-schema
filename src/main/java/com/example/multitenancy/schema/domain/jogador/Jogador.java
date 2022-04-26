package com.example.multitenancy.schema.domain.jogador;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.multitenancy.schema.domain.clube.Clube;

import lombok.Data;

@Entity
@Table(name = "jogador")
@Data
public class Jogador implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "clube_id")
    private Clube clube;
}

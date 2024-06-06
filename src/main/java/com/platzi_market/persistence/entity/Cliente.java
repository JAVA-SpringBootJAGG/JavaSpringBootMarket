package com.platzi_market.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name="clientes")
public class Cliente {

    @Id
    private String id;
    private String nombre;
    private String apellidos;
    private Long celular;
    private String direccion;
    @Column(name="correo_electronico")
    private String correoElectronico;
    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;


}

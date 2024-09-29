package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;

import org.hibernate.envers.Audited;



@Entity
@Table

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder

@Audited
public class Domicilio extends Base {

    private String calle;
    private int numero;
    @ManyToOne(optional = false)  //domicilio si o si debe tener localidad
    @JoinColumn(name = "localidad_fk")
    private Localidad localidad;

}

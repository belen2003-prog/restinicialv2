package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;

import org.hibernate.envers.Audited;

import java.util.HashSet;
import java.util.Set;
//jpa
@Entity
@Table(name="Persona")
//lmbk
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
//auditorias
@Audited

public class Persona extends Base  {

    private String nombre;
    private String apellido;
    private int dni;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_domicilio")
    private Domicilio domicilio;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)  //me aseguro que cuando borro la persona borro los libros que le pertenecen
    @JoinTable(        //esto no es cuando tengo muchos a muchos? o es por lo que es compocicion?
            name= "persona_libro",
            joinColumns = @JoinColumn(name ="persona_id"),
            inverseJoinColumns = @JoinColumn(name = "libro_id")
    )
    @Builder.Default //asegurarte de que tus objetos tengan valores predeterminados adecuados sin necesidad de proporcionar valores explícitamente durante la construcción.
    private Set<Libro> libros = new HashSet<>();

}


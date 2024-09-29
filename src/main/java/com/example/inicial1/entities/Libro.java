package com.example.inicial1.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.Set;
//jpa
@Entity
@Table
//lombok
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
//auditoria
@Audited

public class Libro extends Base{
    private String titulo;
    private int fecha;
    private String genero;
    private int paginas;
    private String autor;

    @ManyToMany(cascade = CascadeType.REFRESH)   //si realizo un cambio en autor se actualiza para libro
    private Set<Autor> autores;  //lista de los autores que pueden haber creado ese libro

}

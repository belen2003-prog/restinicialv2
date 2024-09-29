package com.example.inicial1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.envers.Audited;
//jpa
@Entity
@Table
//lombok
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
//auditoria
@Audited

public class Autor extends Base{
    private String nombre;
    private String apellido;
    @Column(name = "bibliografia" , length = 1500)   //hago que la biografia pueda ser hasta 1500 caracteres
    private String bibliografia;
}

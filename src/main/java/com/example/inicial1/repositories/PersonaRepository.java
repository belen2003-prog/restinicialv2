package com.example.inicial1.repositories;

import com.example.inicial1.entities.Persona;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {
    //empiezo a trabajar con los metodos de query;voy a filtrar los resultados de personas por su nombre o apellido

    List<Persona> findByNombreContainingOrApellidoContaining(String nombre ,String apellido);    //recibo un string para nombre encontrado y otro para apellido.no se usa mucho este metodo porq queda muy largo el nombre del metodo
    Page<Persona> findByNombreContainingOrApellidoContaining(String nombre , String apellido, Pageable pageable); //coon paginacion

   // boolean existsByDni(int dni);  //hacer una verificacion de si existe o no

    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE%:filtro% OR p.apellido LIKE %:filtro%")
    List<Persona> search(@Param("filtro") String filtro);

    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE%:filtro% OR p.apellido LIKE %:filtro%")
    Page<Persona> search(@Param("filtro") String filtro,Pageable pageable); //con paginacion

    //consulta con SQL
    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE%:filtro% OR persona.apellido LIKE %:filtro% ",
            nativeQuery = true
    )
    List<Persona> searchNativo(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE%:filtro% OR persona.apellido LIKE %:filtro% ",
           //cuery de conteo para saber la cantidad de paginas
            countQuery = "SELECT count(*) FROM persona",
            nativeQuery = true
    )
    Page<Persona> searchNativo(@Param("filtro") String filtro,Pageable pegeable); //con paginacion

}
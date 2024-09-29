package com.example.inicial1.services;
import com.example.inicial1.entities.Persona;

import java.util.List;

//paginacion
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface PersonaService extends BaseService<Persona,Long>{
    //metodo base para busqueda
    List<Persona> search (String filtro) throws Exception;
    Page<Persona> search (String filtro, Pageable pageable) throws Exception;  //con paginacion
}

package com.example.inicial1.controllers;

import com.example.inicial1.entities.Base;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.io.Serializable;

import org.springframework.data.domain.Pageable;

//contiene todas las operaciones basicas del controlador
public interface BaseController <E extends Base,ID extends Serializable> {
    //todos los metodos del controlador devuelven el mismo tipo "responseEntity"
    public ResponseEntity<?> getAll();
    public ResponseEntity<?> getAll(Pageable pageable);  //esto que hace
    public ResponseEntity<?> getOne(@PathVariable ID id);
    public ResponseEntity<?> save(@RequestBody E entity);   //recibe una entidad para ser guardada
    public ResponseEntity<?> update (@PathVariable ID id , @RequestBody E entity);
    public ResponseEntity<?> delete (@PathVariable ID id);

}

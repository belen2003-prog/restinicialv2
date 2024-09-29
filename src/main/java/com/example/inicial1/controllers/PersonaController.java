package com.example.inicial1.controllers;

import com.example.inicial1.entities.Persona;
import com.example.inicial1.services.PersonaServicesImp;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


@RestController
@CrossOrigin(origins = "*")           //accedo a datos desde cualquier origen
@RequestMapping(path="/personas")                   //punto de entrada de mi api

public class PersonaController extends BaseControllerImpl <Persona,PersonaServicesImp>{
    //creo el metodo que va a consumir este servicio
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \""+ e.getMessage()+"\"}");

        }
    }
    //mismo metodo pero con paginacion
    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam String filtro, Pageable pageable){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro,pageable));

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \""+ e.getMessage()+"\"}");

        }
    }


}
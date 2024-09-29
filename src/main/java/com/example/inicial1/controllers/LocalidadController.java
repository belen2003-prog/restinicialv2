package com.example.inicial1.controllers;

import com.example.inicial1.entities.Localidad;
import com.example.inicial1.services.LocalidadServiceImp;
import lombok.experimental.SuperBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")           //accedo a datos desde cualquier origen
@RequestMapping(path="/localidades")                   //punto de entrada de mi api
public class LocalidadController extends BaseControllerImpl<Localidad, LocalidadServiceImp> {
}

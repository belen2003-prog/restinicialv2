package com.example.inicial1.controllers;

import com.example.inicial1.entities.Autor;
import com.example.inicial1.services.AutorServiceImp;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")           //accedo a datos desde cualquier origen
@RequestMapping(path="/autores")                   //punto de entrada de mi api

public class AutorController extends BaseControllerImpl<Autor, AutorServiceImp> {
}

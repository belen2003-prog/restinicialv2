package com.example.inicial1.repositories;

import com.example.inicial1.entities.Autor;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends BaseRepository<Autor,Long>{
//heredo de la generica y le digo que los tipos van a ser autor y long

}


package com.example.inicial1.repositories;

import com.example.inicial1.entities.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

//esta es una clase generica repositorio protegido
@NoRepositoryBean   //no quiero que se instancie
public interface BaseRepository <E extends Base,ID extends Serializable>extends JpaRepository<E,ID> {
    //clase genericacon y los tipos que recibe

}

package com.example.inicial1.services;

import com.example.inicial1.entities.Base;

import com.example.inicial1.repositories.BaseRepository;
import jakarta.transaction.Transactional;

//paginacion
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl <E extends Base, ID extends Serializable> implements BaseService<E,ID> {
protected BaseRepository<E,ID> baserepository; //protegio para que lo puedan utilizar la bclases baseservice

    public BaseServiceImpl(BaseRepository<E,ID> baserepository){
this.baserepository = baserepository;   //constructor
}
//implemento los metodos

    @Override
    @Transactional  //hace transacciones ahorro begin commit y rollback
    public List<E> findAll() throws Exception {
        try {
            List<E> entities = baserepository.findAll();
            return entities;
            //obtengo de la bd todas las personas registradas
        } catch (Exception e) {
            throw new Exception(e.getMessage());
            //nueva excepcion capturada por el controlador

        }

    }

    @Override
    @Transactional
    public Page<E> findAll(Pageable pageable) throws Exception {
        try {
            Page<E> entities = baserepository.findAll(pageable);
            return entities;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }



    @Override
    @Transactional
    public E findById(ID id) throws Exception {
        try{
            Optional<E> entityOptional = baserepository.findById(id);
            return entityOptional.get();
            //encuentro entidad y lanso excepcion
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E save(E entity) throws Exception {
        try{
            entity = baserepository.save(entity);
            return entity;
            //uso el save del repositorio
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


    @Override
    @Transactional
    public E update(ID id, E entity) throws Exception {
        try{
            Optional<E> entityOptional = baserepository.findById(id);
            //obtengo la persona que quiero actualizar
            E entityUpdate = entityOptional.get();
            //creo una nueva persona
            entityUpdate= baserepository.save(entity);
            return entityUpdate;
            //actalizo nuevamente y retrno la persona actualizada
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(ID id) throws Exception {
        try{
            if(baserepository.existsById(id)){
                baserepository.deleteById(id);
                return true;
            }else {
                throw new Exception();
            }
            //condicional para saber si existe alguna persona con ese id , si existe lo borro.sino lanso excepcion
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}

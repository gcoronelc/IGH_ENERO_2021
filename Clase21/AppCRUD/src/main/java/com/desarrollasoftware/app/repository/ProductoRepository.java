package com.desarrollasoftware.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.desarrollasoftware.app.entity.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long>{

}

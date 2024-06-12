package com.platzi_market.persistence.crud;

import com.platzi_market.persistence.entity.Producto;
import jakarta.persistence.Column;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    //tambien se pueden hacer de manera nativa con @Query
    //@Query(value = "Select * FROM productos WHERE id_categoria = ?",nativeQuery = true)
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>>findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);


}

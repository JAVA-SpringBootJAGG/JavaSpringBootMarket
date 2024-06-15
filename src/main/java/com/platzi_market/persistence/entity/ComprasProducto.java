package com.platzi_market.persistence.entity;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "compras_productos")
public class ComprasProducto {
    @EmbeddedId
    private ComprasProductoPK id;
    private Integer cantidad;
    private Double total;
    private Boolean estado;
    @ManyToOne
    @MapsId("idCompra")///con esto cuando se guarde compras-productos en cascada sabra a que clave primaria de los productos que esta en una compra
    @JoinColumn(name="id_compra",insertable = false,updatable = false)
    private Compra compra;
    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false,updatable = false)
    private Producto producto;
}

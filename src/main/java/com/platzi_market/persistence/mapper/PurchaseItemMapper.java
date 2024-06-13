package com.platzi_market.persistence.mapper;

import ch.qos.logback.core.model.ComponentModel;
import com.platzi_market.domain.PurchaseItem;
import com.platzi_market.persistence.entity.ComprasProducto;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)//esto ultimo e spara que no haga falta ignorar los no mapeados
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.idProducto",target = "productId"),
            @Mapping(source = "cantidad",target = "quantity"),
            //al ser iguales  source y target no hace falta ponerlo
            @Mapping(source = "total",target = "total"),
            @Mapping(source = "estado",target = "active")
    })
    PurchaseItem toPurchaseItem(ComprasProducto producto);
    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "producto", ignore = true),
            @Mapping(target = "id.idCompra", ignore = true),
    })
    ComprasProducto toComprasProducto(PurchaseItem item);

}

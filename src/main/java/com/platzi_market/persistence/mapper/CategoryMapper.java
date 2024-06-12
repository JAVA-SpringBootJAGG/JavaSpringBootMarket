package com.platzi_market.persistence.mapper;


import com.platzi_market.domain.Category;
import com.platzi_market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
    })
    Category toCategory(Categoria categoria);

    //con la siguiente anotacion indicamos que use el mapeo inverso del que ya tenemos y asi no lo tenemos que especificar
    @InheritInverseConfiguration
    @Mapping(target = "producto", ignore = true)//para  que ignore al hacer el mapeo el atributo productos de entidad Categoria pues Category no lo tiene
    Categoria toCategoria(Category category);
}

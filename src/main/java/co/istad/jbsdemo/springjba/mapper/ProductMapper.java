package co.istad.jbsdemo.springjba.mapper;

import co.istad.jbsdemo.springjba.dto.ProductRequest;
import co.istad.jbsdemo.springjba.dto.ProductRespone;
import co.istad.jbsdemo.springjba.entity.Product;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductRespone mapToProductResponse(Product product);

    Product mapToProduct(ProductRequest productRequest);

    @AfterMapping
    default void setId(@MappingTarget Product product) {
        product.setId(0L);
    }
}

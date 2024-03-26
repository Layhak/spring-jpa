package co.istad.jbsdemo.springjba.service;

import co.istad.jbsdemo.springjba.dto.ProductRequest;
import co.istad.jbsdemo.springjba.dto.ProductRespone;

import java.util.List;

public interface ProductService {
    List<ProductRespone> getAllProducts();

    ProductRespone getProductById(Long id);

    ProductRespone addProduct(ProductRequest productRequest);

    ProductRespone updateProduct(Long id, ProductRequest productRequest);

    ProductRespone deleteProduct(Long id);
}

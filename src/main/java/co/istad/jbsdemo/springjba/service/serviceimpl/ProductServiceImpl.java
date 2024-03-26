package co.istad.jbsdemo.springjba.service.serviceimpl;

import co.istad.jbsdemo.springjba.dto.ProductRequest;
import co.istad.jbsdemo.springjba.dto.ProductRespone;
import co.istad.jbsdemo.springjba.mapper.ProductMapper;
import co.istad.jbsdemo.springjba.repository.ProductRepository;
import co.istad.jbsdemo.springjba.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductRespone> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::mapToProductResponse)
                //.map(product -> productMapper.mapToProductResponse(product))
                .toList();
    }

    @Override
    public ProductRespone getProductById(Long id) {
        return null;
    }

    @Override
    public ProductRespone addProduct(ProductRequest productRequest) {
        return productMapper.mapToProductResponse(productRepository.save(productMapper.mapToProduct(productRequest)));
    }

    @Override
    public ProductRespone updateProduct(Long id, ProductRequest productRequest) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setTitle(productRequest.title());
                    product.setDescription(productRequest.description());
                    product.setImageUrl(productRequest.imageUrl());
                    product.setPrice(productRequest.price());
                    return productMapper.mapToProductResponse(productRepository.save(product));
                })
                .orElseThrow();
    }

    @Override
    public ProductRespone deleteProduct(Long id) {
        var deletedProduct = productRepository.findById(id).orElseThrow();
        productRepository.deleteById(id);
        return productMapper.mapToProductResponse(deletedProduct);
    }
}


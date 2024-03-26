package co.istad.jbsdemo.springjba.restcontroller;

import co.istad.jbsdemo.springjba.dto.ProductRequest;
import co.istad.jbsdemo.springjba.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Slf4j
public class ProductRestController {
    private final ProductService productService;

    private HashMap<String, Object> generateResponse(String message, Object payload, HttpStatus status) {
        HashMap<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("payload", payload);
        response.put("status", status.value());
        return response;
    }

    @GetMapping
    public HashMap<String, Object> getAllProducts() {
        return generateResponse("success", productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String, Object> saveProduct(@Valid @RequestBody ProductRequest request) {
        return generateResponse("success", productService.addProduct(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public HashMap<String, Object> updateProduct(@PathVariable Long id, @RequestBody ProductRequest request) {
        return generateResponse("success", productService.updateProduct(id, request), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HashMap<String, Object> deleteProduct(@PathVariable Long id) {
        return generateResponse("success", productService.deleteProduct(id), HttpStatus.OK);
    }


}

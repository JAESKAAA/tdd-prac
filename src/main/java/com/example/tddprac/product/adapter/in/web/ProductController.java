package com.example.tddprac.product.adapter.in.web;

import com.example.tddprac.product.application.port.in.ProductReadUsecase;
import com.example.tddprac.product.application.port.in.ProductWriteUsecase;
import com.example.tddprac.product.application.service.dto.AddProductRequest;
import com.example.tddprac.product.application.service.dto.GetProductResponse;
import com.example.tddprac.product.application.service.dto.UpdateProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductWriteUsecase productWriteUsecase;
    private final ProductReadUsecase productReadUsecase;

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody AddProductRequest request) {

        productWriteUsecase.addProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<GetProductResponse> getProduct(@PathVariable Long productId) {
        GetProductResponse response = productReadUsecase.getProduct(productId);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<Void> updateProduct(@PathVariable Long productId, @RequestBody UpdateProductRequest request) {

        productWriteUsecase.updateProduct(productId, request);

        return ResponseEntity.ok().build();
    }

}

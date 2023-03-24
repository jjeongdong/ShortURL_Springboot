package com.example.testproject.service.impl;

import com.example.testproject.data.dto.ProductDto;
import com.example.testproject.data.entity.ProductEntity;
import com.example.testproject.data.handler.ProductDataHandler;
import com.example.testproject.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService {
    ProductDataHandler productDataHandler;

    @Autowired
    public ProductServiceImpl(ProductDataHandler productDataHandler) {
        this.productDataHandler = productDataHandler;
    }

    @Override
    public ProductDto saveProduct(String productId, String productName, int productPrice,
                                  int productStock) {

        ProductEntity product = productDataHandler.saveProductEntity(productId, productName,
                productPrice, productStock);

        ProductDto productDto = new ProductDto(product.getId(),
                product.getName(), product.getPrice(),
                product.getStock());

        return productDto;
    }

    @Override
    public ProductDto getProduct(String productId) {

        ProductEntity product = productDataHandler.getProductEntity(productId);

        ProductDto productDto = new ProductDto(product.getId(),
                product.getName(), product.getPrice(),
                product.getStock());

        return productDto;
    }
}
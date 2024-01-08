package com.enigma.tokopedia.Service.Impl;

import com.enigma.tokopedia.Dto.Request.ProductRequest;
import com.enigma.tokopedia.Dto.Response.ProductResponse;
import com.enigma.tokopedia.Dto.Response.StoreResponse;
import com.enigma.tokopedia.Entity.Product;
import com.enigma.tokopedia.Entity.ProductPrice;
import com.enigma.tokopedia.Entity.Store;
import com.enigma.tokopedia.Repositori.ProductPriceRepositori;
import com.enigma.tokopedia.Repositori.ProductRepositori;
import com.enigma.tokopedia.Service.ProductPriceService;
import com.enigma.tokopedia.Service.ProductService;
import com.enigma.tokopedia.Service.StoreService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepositori productRepositori;
    private final StoreService storeService;
    private final ProductPriceRepositori productPriceRepositori;
    private final ProductPriceService productPriceService;

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        return null;
    }

    @Override
    public ProductResponse getByIdProduct(ProductRequest productRequest) {
        return null;
    }

    @Override
    public List<ProductResponse> getAllProduct() {
        return null;
    }

    @Override
    public ProductResponse updateProduct(ProductRequest productRequest) {
        return null;
    }

    @Override
    public void deleteProduct(String id) {

    }


    @Transactional(rollbackOn = Exception.class) // untuk rollback jika gagal
    @Override
    public ProductResponse createProductAndProductPrice(ProductRequest productRequest) {
        // product price ambil product id dan store id
        // ambil store response by id
        Store store = new Store();
        StoreResponse storeResponse = storeService.getStoreById(productRequest.getStoreId().getId());
        System.out.println(storeResponse);


        // Mapping Product
        Product product = Product.builder()
                .name(productRequest.getProductName())
                .description(productRequest.getDescription())
                .build();
        System.out.println("Hasil Product : " + product);
        // Create Product
        productRepositori.save(product);

        //  Lalu buat Produk Price(Mapping)
        ProductPrice productPrice = ProductPrice.builder()

                .stock(productRequest.getStock())
                .price(productRequest.getPrice())
                .isActive(true)
                .product(product)
                // Mapping Store
                .store(Store.builder()
                        //ambil dri atas
                        .id(storeResponse.getId())
                        .build())
                .build();


        System.out.println("hasil productPrice: " + productPrice.getProduct().getProductPrices());
        productPriceService.create(productPrice);

        return toProductResponse(store,product,productPrice);
    }

    @Override
    public Page<ProductResponse> getAllByNameOrPrice(String name, Long maxPrice, Integer page, Integer size) {
        return null;
    }


    private static ProductResponse toProductResponse(Store store, Product product, ProductPrice productPrice) {


        return ProductResponse.builder()
                .id(product.getId())
                .productName(product.getName())
                .description(product.getDescription())
                //ini dari Product Price
                .price(productPrice.getPrice())
                .stock(productPrice.getStock())
                .store(StoreResponse.builder()
                        .id(store.getId())
                        .mobilePhone(store.getMobilePhone())
                        .build())
                .productPrice(productPrice.toBuilder()
                        .price(productPrice.getPrice())
                        .build())
                .build();
    }


}
